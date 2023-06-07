package com.citiustech.flightmanagementusingspringboot.controller;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.flightmanagementusingspringboot.models.Booking;
import com.citiustech.flightmanagementusingspringboot.service.BookingService;
import com.razorpay.*;
@RestController
@CrossOrigin("*")
public class BookingController {

	@Autowired
	private BookingService bookservice;
	
	@PostMapping(value="/bookflight/{custid}/{flightid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String bookFlight(@PathVariable("custid") int cid,@PathVariable("flightid") int fid,@RequestBody Booking b) throws RazorpayException {
		
		System.out.print(b);
		
		return bookservice.insert(cid,fid,b);	
	}
	@PostMapping(value="/book", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean payment(@RequestBody Object data) {
		System.out.println(data);
		return bookservice.payment(data);
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
	
	@DeleteMapping("/cancelflight/{bookid}/{flightid}/{not}")
	public void cancelFlight(@PathVariable("bookid") int id,@PathVariable("flightid") int fid,@PathVariable("not") int not) {
		//System.out.println(b);
		bookservice.cancelFlight(id,fid,not);
	}
}
