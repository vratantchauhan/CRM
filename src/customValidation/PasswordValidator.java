package customValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import org.springframework.stereotype.Component;



@Component
public class PasswordValidator implements ConstraintValidator<Password, String>{
	
	public static String passwordGiven;

	@Override
	public boolean isValid(String password, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		//password.concat(passwordGiven);
		System.out.println(password+" entered pasword");
		setPasswordGiven(password);
		System.out.println(passwordGiven+" passwordGiven");
		return true;
	}
	public String getPasswordGiven() {
		return passwordGiven;
	}
	public void setPasswordGiven(String password) {
		PasswordValidator.passwordGiven = password;
	}
	
	

}
