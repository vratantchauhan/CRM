package DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.CRM.Customer;
import com.CRM.CustomerController;

import java.util.ArrayList;
import java.util.List;
import java.util.List.*;

@Repository
public class CustomerDAO implements CustomerDAOInterface{
	
	public CustomerDAO() {
		
	}
	
	@Autowired
	Customer customer;

	ArrayList<Customer> custoList;
	
	SessionFactory factory;
	Session session;
	
	@Autowired
	CustomerController cc;
	
	public void sessionCreate() {
		
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).buildSessionFactory();
		session = factory.getCurrentSession();
	}
	
	
	public void saveCustomer(Customer customer) {
		
		sessionCreate();
		
		this.customer = customer;
		
		try {
			session.beginTransaction();
			session.save(customer);
			session.getTransaction().commit();
		}finally {
			factory.close();
			}
	}
	
	
	public Customer viewCustomer(Customer customer) {
		
			this.customer = customer;
			
			sessionCreate();
			
			try {
				session.beginTransaction();
				Customer getCustomer =  session.get(Customer.class, customer.getId());
				session.getTransaction().commit();
				System.out.println(getCustomer);
				return getCustomer;
			}
				finally {
				factory.close();
				}
			
		}

	public ArrayList<Customer> viewAllCustomer() {
		
		sessionCreate();
		
		try {
			
			session.beginTransaction();
			
			custoList = (ArrayList<Customer>) session.createQuery("from Customer").getResultList();
			
			session.getTransaction().commit();
		
			return custoList;
				
			}finally {
				factory.close();
				}
		
		
	}

	public void deleteCustomer(Customer customer) {
		
		this.customer = customer;
		
		sessionCreate();
		
		try {
			
			session.beginTransaction();
			
			Customer delCustomer =  session.get(Customer.class, customer.id);
	
			session.delete(delCustomer);
			
			session.getTransaction().commit();
		
		}finally {
			factory.close();
			}
	}
	
	public void updateCustomer(Customer customer, int id, String name,String p_number,String email,String branch) {
			
			this.customer = customer;
			
			sessionCreate();
			
			try {
				
				session.beginTransaction();
		
				session.createQuery("update Customer set name='"+name+"',phone_number='"+p_number+"',email='"+email+"',branch='"+branch+"' where id = "+id).executeUpdate();
				
				session.getTransaction().commit();
			
			}finally {
				factory.close();
				}
		}
	
	}



	
	