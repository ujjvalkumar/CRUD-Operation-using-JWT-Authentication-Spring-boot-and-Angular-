package com.rest.ujjval.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.ujjval.Service.CustomerService;
import com.rest.ujjval.model.Customer;
@RestController
@RequestMapping("/api/customers")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @PostMapping("/customer") //http://localhost:8001/api/customers/customer --Insert
                              //http://localhost:8001/api/customers/customer  -Update
    public ResponseEntity<String> getCustomer(@RequestBody Customer customer){
    	String msg=customerService.upsertCustomer(customer);
    	return new ResponseEntity<>(msg,HttpStatus.CREATED);
    }
    @GetMapping("/allcustomer") //http://localhost:8001/api/customers/allcustomer
    public ResponseEntity<List<Customer>> getAllCustomer(){
    	List<Customer> allCustomer=customerService.getAllCustomer();
    	return new ResponseEntity<>(allCustomer,HttpStatus.OK);
    }
    
    @DeleteMapping("/customer/{id}") //http://localhost:8001/api/customers/customer/10
    public ResponseEntity<String> deletecustomer(@PathVariable long id){
    	String msg=customerService.deleteCustomer(id);
    	return new ResponseEntity<>(msg,HttpStatus.OK);
    }
    
}
