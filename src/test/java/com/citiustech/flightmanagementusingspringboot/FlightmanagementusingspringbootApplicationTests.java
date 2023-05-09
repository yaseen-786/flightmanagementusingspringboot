package com.citiustech.flightmanagementusingspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.citiustech.flightmanagementusingspringboot.dao.CustomerRepository;
import com.citiustech.flightmanagementusingspringboot.models.Customer;
import com.citiustech.flightmanagementusingspringboot.service.CustomerService;

import jakarta.annotation.security.RunAs;


@SpringBootTest
@RunWith(SpringRunner.class)
class FlightmanagementusingspringbootApplicationTests {

	@Test
		public void getAllCustomer() {
			when(repo.findAll()).thenReturn((Stream.of(new Customer(101,"yaseen","yaseen","yaseen123","yk@gmail.com","810493107"),
					new Customer(102,"admin","admin","admin123","ak@gmail.com","810493107"))).collect(Collectors.toList()));
			assertEquals(2,service.getAllCustomer().size());
			
		}



	@Autowired
	private CustomerService service;
	
	@MockBean
	private CustomerRepository repo;
	
	}
