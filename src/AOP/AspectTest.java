package AOP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CRM.Customer;
import com.CRM.LoginValidation;
import com.CRM.User;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
//import com.CRM.*;
//import DAO.CustomerDAO;

@Component
@Aspect
public class AspectTest {
	
	
	ArrayList<Customer> custoList;

	@AfterThrowing(pointcut="execution(* DAO.CustomerDAO.*(..))",throwing="e")
	public void exceptionCaught(JoinPoint jp, Throwable e) {
		System.out.println("the exception caused is: "+e);
	}
	
	@Pointcut("execution(* DAO.CustomerDAO.*(..))")
	public void logger() {}
	
	@Before("logger()")
	public void beforeViewCustomer(JoinPoint jp) throws Throwable {
		MethodSignature ms = (MethodSignature) jp.getSignature();
		System.out.println("logging method call: "+ms);
		Object[] args = jp.getArgs();
		for(Object argsDisplay : args) {
			System.out.println("Logging agruments of the method call: "+ argsDisplay);
			Customer customer = (Customer) argsDisplay;  
			System.out.println("customer with id: "+customer.getId());
			
		}
	}
	
	@Pointcut("execution(* *.*.logError(..))")
	public void errorLog() {}
	
	@Before("errorLog()")
	public void errorLogged(JoinPoint jp) {
		Object[] err = jp.getArgs();
		for(Object errDisplay:err) {
			System.out.println("Error dadadadadadadaa: "+errDisplay);
		}
	}
	
//	@Pointcut("execution(* DAO.CustomerDAO.viewCustomer(..))")
//	public void customerDetails() {}
//	
//	@AfterReturning(pointcut = "customerDetails()", returning = "customerViewed")
//	public void viewCustomer(JoinPoint jp, Customer customerViewed) {
//		
//		System.out.println("user viewed was :"+customerViewed.getName());
//	}
	
	@Before("execution(* DAO.UserDAO.register(..))")
	public void encode(JoinPoint jp) {
		Object[] args = jp.getArgs();
		for(Object argsDisplay : args) {
		User user = (User) argsDisplay;
		System.out.println("inside encode aspect, password entered is :" +user.getPassword());
		String encoded="";
		encoded = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(12));
		user.setPassword(encoded);
		System.out.println("inside encode aspect, password encoded is :" +user.getPassword());

		}
	}
	
	@Around("execution(* DAO.CustomerDAO.viewAllCustomer(..))")
	public ArrayList<Customer> timeTakenToViewAllCustomers(ProceedingJoinPoint pjp) throws Throwable {
		
		Long begin = System.currentTimeMillis();
		custoList = (ArrayList<Customer>) pjp.proceed();
		Long end = System.currentTimeMillis();
		Long total = end - begin;
		Logger myLogger = Logger.getLogger(getClass().getName());
		myLogger.info("=========> time taken: "+total);
		return custoList;
	}
	
//	
//	@Before("execution(* DAO.UserDAO.decode(..))")
//	public void decoding(JoinPoint jp) {
//		System.out.println("kjdhasha");
//		Object[] args = jp.getArgs();
////		boolean valid = (boolean) args[0];
//		LoginValidation userCheck = (LoginValidation) args[1];
//		User user = (User) args[0];
//		System.out.println("valid val in aspect: "+args[2]);
//		if(BCrypt.checkpw(userCheck.getPassword(),user.getPassword())) {
//			args[2]=true;
//			System.out.println(args[2]);
//		}
//	}
//	
	
	
}
