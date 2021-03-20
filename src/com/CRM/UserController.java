package com.CRM;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import DAO.UserDAO;

@Controller
public class UserController {

	@Autowired
	User user;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	LoginValidation userValidate;
	
	@GetMapping(value="/signup")
	String signup(Model model) {
		
		model.addAttribute("user", user);
		return "signup";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	String register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return"signup";
		}
		userDAO.register(user);
		return "login";
	}
	
	@GetMapping(value="/login")
	String login(Model model) {
		
		model.addAttribute("user", userValidate);
		return "login";
	}
	
	@PostMapping(value="/loggingin")
	String loggedin(@Valid @ModelAttribute("user") LoginValidation user, BindingResult bindingResult) {
		System.out.println("inside loggingin");
		if(bindingResult.hasErrors()) {
			System.out.println("error");
			return "login";
		}
		boolean valid = false; 
		System.out.println("before func");
		valid = userDAO.loginCheck(user);
		System.out.println("after func");
		if(valid==true) {
			System.out.println("homepage");
			return "homepage";
		}else {
			System.out.println(" no homepage");
			return"login";	
		}
		
	}
	
	@RequestMapping(value="/backToHomePage", method=RequestMethod.POST)
	String backToHomePage() {
		
		return "homepage";
	}
	
	
}
