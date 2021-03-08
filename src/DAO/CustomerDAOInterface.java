package DAO;

import java.util.ArrayList;

import com.CRM.Customer;

public interface CustomerDAOInterface {

	public void saveCustomer(Customer customer);
	
	public Customer viewCustomer(Customer customer);
	
	public ArrayList<Customer> viewAllCustomer();
	
	public void deleteCustomer(Customer customer);
	
	public void updateCustomer(Customer customer, int id, String name,String p_number,String email,String branch);
}
