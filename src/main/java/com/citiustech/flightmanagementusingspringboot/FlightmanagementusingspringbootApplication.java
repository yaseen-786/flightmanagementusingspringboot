package com.citiustech.flightmanagementusingspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.citiustech.flightmanagementusingspringboot.dao.CustomerRepository;
import com.citiustech.flightmanagementusingspringboot.models.Customer;
import com.citiustech.flightmanagementusingspringboot.service.CustomerService;


@SpringBootApplication
public class FlightmanagementusingspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightmanagementusingspringbootApplication.class, args);
//		ApplicationContext context =SpringApplication.run(FlightmanagementusingspringbootApplication.class, args);
//		CustomerService custserv = context.getBean(CustomerService.class);
//		Customer c = new Customer();
//		c.setName("yaseen");
//		
//		custserv.insertIntoCustomer(c);
	}

}
