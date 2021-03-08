package com.CRM;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="user_name")
	@NotBlank(message="Please enter a username.")
	String userName;
	
	@Column(name="email_id")
	@Email(message="Must be an email.")
	@NotBlank
	String email;
	
	@Column(name="phone_number")
	@NotBlank(message="Enter Phone number.")
	@Size(min=10,max=10,message="phone number must be 10 digits long.")
	String PhoneNumber;
	
	
//	@Password
	@Column(name="password")
	@Size(min=7,message="password must be 7 characters long.")
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{7,}$", message="Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character")
	String password;
	
//	@Size(min=7,message="password must be 7 characters long.")
////	@ConfirmPassword(message="Passwords must match")
//	String confirmPassword;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public String getConfirmPassword() {
//		return confirmPassword;
//	}
//
//	public void setConfirmPassword(String confirmPassword) {
//		this.confirmPassword = confirmPassword;
//	}
	
	
	
	
}
