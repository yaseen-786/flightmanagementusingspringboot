package com.citiustech.flightmanagementusingspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.flightmanagementusingspringboot.dao.BookingRepository;
import com.citiustech.flightmanagementusingspringboot.dao.CustomerRepository;
import com.citiustech.flightmanagementusingspringboot.models.Booking;
import com.citiustech.flightmanagementusingspringboot.models.Customer;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository custrepo;
	
	@Autowired
	private BookingService bookservice;
	
	@Autowired
	private BookingRepository bookrepo;
	
	
	public Customer insertIntoCustomer(Customer cust) {
		return custrepo.save(cust);
	}
	
	public Customer getCustomerById(int id) {
		return custrepo.findByCustid(id);
	}
	
	public List<Customer> getAllCustomer(){
		return custrepo.findAll();
	}

	public void updateCustomer(Customer cust,int id) {
		// TODO Auto-generated method stub
		Customer cust1 =custrepo.findByCustid(id);
		cust1.setName(cust.getName());
		cust1.setUsername(cust.getUsername());
		cust1.setPassword(cust.getPassword());
		cust1.setPhone(cust.getPhone());
		cust1.setEmail(cust.getEmail());
		custrepo.save(cust1);
		
	}
	
	public void deleteCustomer(int id) {
		List<Booking> booklist = bookservice.getAllBookingOfCustomer(id);
		bookrepo.deleteAll(booklist);
		custrepo.delete(custrepo.findByCustid(id));
	}
	
	public boolean validatingCustomer(Customer cust) {
		boolean flag = false;
		System.out.println(cust);
		Customer c = custrepo.findByUsernameAndPassword(cust.getUsername(), cust.getPassword());
		if(c!=null) {
			flag = true;
		}
		return flag;
	}
	
	
	public Customer getCustomer(String username) {
		return custrepo.findByUsername(username);
	}

}
