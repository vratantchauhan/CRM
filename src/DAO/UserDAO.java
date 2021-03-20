package DAO;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.mindrot.jbcrypt.*;

import com.CRM.LoginValidation;
import com.CRM.User;
import com.mysql.cj.Query;

@Component
public class UserDAO {

	SessionFactory factory;
	Session session;
	
	@Autowired
	User userCheck;
	
	@Autowired
	LoginValidation user;
	
	void createSession() {
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
		session = factory.getCurrentSession();
	}
	
	String encode(User user) {
		String encoded="";
		encoded = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(12));
		return encoded;
	}
	
	Boolean decode(User userCheck,LoginValidation user, Boolean valid) {
		
		System.out.println(userCheck.getPassword());
		if(BCrypt.checkpw(user.getPassword(),userCheck.getPassword())) {
			valid=true;
		}
		return valid;
	}
		
	public void register(User user) {

//		String encoded = encode(user);
//		user.setPassword(encoded);
//		user.setConfirmPassword(encoded);
		System.out.println("password recived by register method: "+user.getPassword());
		try{
			createSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		}catch(Exception e){
			System.out.println(e);
		}finally {
//			session.close();
			factory.close();
		}
	}
	
	public Boolean loginCheck(LoginValidation user) {
		
		boolean valid=false;
		
		try {
			createSession();
			session.beginTransaction();
			userCheck = session.get(User.class, user.getId());
			session.getTransaction().commit();
			System.out.println(user.getPassword()+" entered pass");
			valid = decode(userCheck,user,valid);
			System.out.println("valid val: "+valid);
			System.out.println(userCheck.getPassword());
		}catch(Exception e) {
			System.out.println(e);
			
		}finally {
			
			factory.close();
		}
		return valid;
	}
}















//String encodeSHA256(User user) {
//MessageDigest digest;
//try {
//	digest = MessageDigest.getInstance("SHA-256");
//	byte[] hash = digest.digest(user.getPassword().getBytes(StandardCharsets.UTF_8));
//	String encoded = Base64.getEncoder().encodeToString(hash);
//	return encoded;
//	
//} catch (NoSuchAlgorithmException e1) {
//	// TODO Auto-generated catch block
//	e1.printStackTrace();
//}
//}