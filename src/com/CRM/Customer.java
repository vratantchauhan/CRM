package com.CRM;



import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Component
@Entity
@Table(name="customer")
public class Customer {

	public Customer() {
		
	}

	@Id
	@Column(name ="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;

	
	
	@Column(name="name")
	@NotBlank(message="Enter a name")
	@Pattern(regexp = "^[A-Za-z]*$")
	String name;
	
	@NotBlank(message="Enter a Phone Number")
	@Column(name="phone_number")
	@Size(min=10, max=10, message="Phone number has to be 10 digits")
	@Pattern(regexp = "^[0-9]*$", message="numbers only")
	String phoneNumber;
	
	@NotBlank(message="Enter an Email")
	@Column(name="email")
	//@Pattern(regexp = "^[.+@+.]*$")
	@Email(message="must be email")
	String email;
	
	@NotBlank(message="Enter the branch")
	@Column(name="branch")
	String branch;
	
	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
	}
	
	public void cloneFrom(Customer customer) {
		this.id = customer.id;
		this.name = customer.name;
		this.phoneNumber = customer.phoneNumber;
		this.email=customer.email;
		this.branch=customer.branch;
	}
	
}

