package com.citiustech.flightmanagementusingspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.flightmanagementusingspringboot.models.Booking;
import com.citiustech.flightmanagementusingspringboot.service.BookingService;

@RestController
@CrossOrigin("*")
public class BookingController {

	@Autowired
	private BookingService bookservice;
	
	@PostMapping("/bookflight/{custid}/{flightid}")
	public Booking bookFlight(@PathVariable("custid") int cid,@PathVariable("flightid") int fid,@RequestBody Booking b) {
		return bookservice.insert(cid,fid,b);
	}
	
	@GetMapping("/getbooking/{bookid}")
	public Booking getBookingOfId(@PathVariable("bookid") int id) {
		return bookservice.getBookingById(id);
	}
	@GetMapping("/booking/{custid}")
	public List<Booking> getbookingofcustomer(@PathVariable("custid") int id){
		return bookservice.getAllBookingOfCustomer(id);
	}
	@GetMapping("/getallbooking")
	public List<Booking> getBookingOfId() {
		return bookservice.getAllBooking();
	}
	
	@DeleteMapping("/cancelflight/{bookid}")
	public void cancelFlight(@PathVariable("bookid") int id) {
		bookservice.cancelFlight(id);
	}
}
