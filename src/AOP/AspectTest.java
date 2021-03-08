package AOP;

import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.*;


@Component
@Aspect
public class AspectTest {

	@Before("execution(* DAO.CustomerDAO.viewCustomer())")
	public void beforeViewCustomer() {
		System.out.println("Before Aspect running");
	}
}
