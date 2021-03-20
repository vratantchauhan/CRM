package com.CRM;

import java.net.BindException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import DAO.CustomerDAO;

//@Validated
@Controller
//@PropertySource("classpath:customer.properties")
public class CustomerController {
	
	public CustomerController() {
		
	}
	
	@Autowired
	Customer customer;
	
	@Autowired
	CustomerDAO customerDAO;
	
	ArrayList<Customer> cusList;
	
//	@Value("${customer.id}")
	int idd;
//	System.out.println("");
	@RequestMapping("/")
	String index() {
		return "index";
	}
	
	@RequestMapping("/listCustomers")
	String listCustomersPage(Model model) {
		model.addAttribute("customer",customer);
//		customer=customerDAO.viewCustomer(customer);
		System.out.println(idd+"from prop.");
		return "listCustomers";
	}
	

	@RequestMapping("/listCustomerResult")
	String listCustomerResult(@ModelAttribute("customer") Customer customer) {
		System.out.println(idd+"from prop.");

		Customer getCustomer=customerDAO.viewCustomer(customer);
		if (getCustomer==null){
			return"error";
		}
		customer.cloneFrom(getCustomer);
		
		return "listCustomerResult";
	}
	
	@RequestMapping("/listAllCustomers")
	String listAllCustomerResult(@ModelAttribute("customer") ArrayList<Customer> customer) {
		
		cusList = customerDAO.viewAllCustomer();
		customer.addAll(cusList);
		return "listAllCustomers";
	}

	@RequestMapping("/insertCustomer")
	String insertCustomerPage(Model model) {
		
		model.addAttribute("customer", customer);
		
		return "insertCustomer";
	}
	
	@RequestMapping(value="/saveResultt")
	public String saveResult(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
		
//		customer1.cloneFrom(customer);
		
		System.out.println(bindingResult);

		if(bindingResult.hasErrors()) {
			
			System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhh");
			return "insertCustomer"; 
		}else {
		
		customerDAO.saveCustomer(customer);
		return "saveResult";
	}}
//	@ExceptionHandler(ConstraintViolationException.class)
//	public void bindExceptionHandler(ConstraintViolationException ex, HttpServletRequest request) {
//		System.out.println(ex.toString());
//	}
	
	@RequestMapping("/deleteCustomer")
	String deleteCustomerPage(Model model) {

		model.addAttribute("customer", customer);
		return "deleteCustomer";
	}
	
	@RequestMapping(value="/deleteResult")
	public String deleteResult(@ModelAttribute("customer") Customer customer) {
		
		customerDAO.deleteCustomer(customer);
		return "deleted";
	}
	
	@RequestMapping("/updateCustomer")
	String updateCustomerPage(Model model) {
	
		model.addAttribute("customer", customer);
		System.out.println(customer.id);
		return "updateCustomer";
	}
	
	@RequestMapping("/listCustomerResultForUpdate")
	String listCustomerResultForUpdate(@ModelAttribute("customer") Customer customer) {
		
		Customer getCustomer=customerDAO.viewCustomer(customer);
		if (getCustomer==null){
			return"error";
		}
		customer.cloneFrom(getCustomer);
		customer.setId(getCustomer.id);
		
		idd=customer.id;
		return "listCustomerResultForUpdate";
	}
	
	@RequestMapping("/updateResult")
	public String updateResult(@ModelAttribute("customer") Customer customer) {
	
		int id=idd;
		System.out.println(idd);
		String p_number=customer.phoneNumber;
		String name=customer.name;
		String email=customer.email;
		String branch=customer.branch;
		customer.setId(idd);
		customerDAO.updateCustomer(customer,id,name,p_number,email,branch);
		return "updateResult";
	}
	
	@RequestMapping("/backToHomePage")
	public String backToHomePage() {
	
		
		return "homepage";
	}
}
