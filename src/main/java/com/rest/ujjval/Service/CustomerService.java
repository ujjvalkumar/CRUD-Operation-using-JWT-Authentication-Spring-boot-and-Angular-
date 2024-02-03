package com.rest.ujjval.Service;

import java.util.List;

import com.rest.ujjval.model.Customer;

public interface CustomerService {
	
	
	
	public String upsertCustomer(Customer customer);
	public List<Customer> getAllCustomer();
	public String deleteCustomer(Long id);
	
	
	
}
