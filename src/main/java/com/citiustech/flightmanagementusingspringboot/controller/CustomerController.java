package com.citiustech.flightmanagementusingspringboot.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.flightmanagementusingspringboot.models.Customer;
import com.citiustech.flightmanagementusingspringboot.service.CustomerService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class CustomerController {
	
	@Autowired
	private CustomerService custservice;
	
	@PostMapping("/customerregister")
	public void insertCustomer(@RequestBody Customer cust){
		custservice.insertIntoCustomer(cust);
	}
	
	@PostMapping("/validatecustomer")
	public boolean validateCustomer(@RequestBody Customer cust){
		return custservice.validatingCustomer(cust);
	}
	
	@GetMapping("/getcustomer/{custid}")
	public Customer getCustomer(@PathVariable("custid") int id) {
		return custservice.getCustomerById(id);
	}
	@GetMapping("/getcust/{custname}")
	public Customer getCustomerbyUsername(@PathVariable("custname") String id) {
		return custservice.getCustomer(id);
	}
	
	@GetMapping("/getallcustomer")
	public List<Customer> getAllCustomer(){
		return custservice.getAllCustomer();
	}
	
	@PutMapping("/customerupdate/{custid}")
	public void updateCustomer(@RequestBody Customer cust,@PathVariable("custid") int id) {
		custservice.updateCustomer( cust, id);
	}
	
	@DeleteMapping("/customerdelete/{custid}")
	public void deleteCustomer(@PathVariable("custid") int id) {
		custservice.deleteCustomer(id);
	}

}
