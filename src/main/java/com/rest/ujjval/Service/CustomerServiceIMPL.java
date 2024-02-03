package com.rest.ujjval.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.ujjval.Repository.CustomerRepository;
import com.rest.ujjval.model.Customer;

@Service
public class CustomerServiceIMPL implements CustomerService {
	
	
	private CustomerRepository customerRepository;
	public CustomerServiceIMPL(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	

	@Override
	public String upsertCustomer(Customer customer) {
		Long customerId=customer.getId();
		System.out.println(customer);
		Customer save=customerRepository.save(customer);
		System.out.println(customer);
		if(customerId == null) {
			return "Customer Insert";
		}else {
			return "Customer Update";
		}
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public String deleteCustomer(Long id) {
		customerRepository.deleteById(id);
		return "Book Deleted";
	}

	
    

}
