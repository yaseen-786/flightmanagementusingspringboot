package com.citiustech.flightmanagementusingspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.flightmanagementusingspringboot.models.Flight;
import com.citiustech.flightmanagementusingspringboot.service.FlightService;

@RestController
@CrossOrigin("*")
public class FlightController {
	
	@Autowired
	private FlightService flightservice;
	
	@PostMapping("/flightregister")
	public void insertFlight(@RequestBody Flight f) {
		flightservice.insertFlight(f);	
	}
	
	@GetMapping("/getflight/{flightid}")
	public Flight getFlight(@PathVariable("flightid") int id) {
		return flightservice.getFlightById(id);
	}
	
	@GetMapping("/getallflight")
	public List<Flight> getAllFlight(){
		return flightservice.getAllFlight();
	}
	
	@GetMapping("/getallsourcelocation")
	public List<String> getSourceName(){
		return flightservice.getSource();
	}
	
	@GetMapping("/getalldestinationlocation")
	public List<String> getDestinationName(){
		return flightservice.getDestination();
	}
	
	@GetMapping("/getdetails/{source}/{destination}/{date}")
	public List<Flight> getDetails(@PathVariable("source") String source,@PathVariable("destination") String destination,@PathVariable("date") String date){
		System.out.println(date);
		return flightservice.getflights(source,destination,date);
	}
	
	@PutMapping("/flightupdate/{flightid}")
	public void updateFlight(@RequestBody Flight f,@PathVariable("flightid") int id) {
		flightservice.updateFlight(f,id);
	}
	
	@DeleteMapping("/flightdelete/{flightid}")
	public void deleteFlight(@PathVariable("flightid") int id) {
		flightservice.deleteFlight(id);
	}

}
