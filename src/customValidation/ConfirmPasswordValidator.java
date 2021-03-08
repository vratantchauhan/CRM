package customValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class ConfirmPasswordValidator implements ConstraintValidator<ConfirmPassword, String>{
	
	@Autowired
	PasswordValidator pw;
	
	@Override
	public boolean isValid(String confirmPassword, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		try {
			if(confirmPassword!="") {
				System.out.println(confirmPassword+"enter confirm pass");
				System.out.println(pw.getPasswordGiven());
				System.out.println("inside 1st validation if");
				if(confirmPassword.equals(pw.getPasswordGiven())) {
					System.out.println("inside 2nd validation if");
					System.out.println("correct confirm Password");
					return true;
				}else {
					return false;
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
