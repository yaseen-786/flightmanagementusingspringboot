package com.citiustech.flightmanagementusingspringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.flightmanagementusingspringboot.models.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Integer>{
	public Customer findByUsername(String username);
	public Customer findByUsernameAndPassword(String username,String password);
	public Customer findByCustid(int id);

}
