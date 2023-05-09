package com.citiustech.flightmanagementusingspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.flightmanagementusingspringboot.dao.BookingRepository;
import com.citiustech.flightmanagementusingspringboot.dao.FlightRepository;
import com.citiustech.flightmanagementusingspringboot.models.Booking;
import com.citiustech.flightmanagementusingspringboot.models.Flight;

@Service
public class FlightService {
	
	@Autowired
	private FlightRepository flightrepo;
	
	@Autowired
	private BookingService bookservice;
	
	@Autowired
	private BookingRepository bookrepo;
	
	public void insertFlight(Flight f) {
		
		flightrepo.save(f);
	}

	public Flight getFlightById(int id) {
		// TODO Auto-generated method stub
		return flightrepo.findByFlightid(id);
	}

	public List<Flight> getAllFlight() {
		// TODO Auto-generated method stub
		return flightrepo.findAll();
	}

	public List<String> getSource() {
		// TODO Auto-generated method stub
		return flightrepo.getAllSource();
	}

	public List<String> getDestination() {
		 // TODO Auto-generated method stub
		return flightrepo.getAllDestination();
	}

	public void updateFlight(Flight f,int id) {
		// TODO Auto-generated method stub
		Flight fli = flightrepo.findByFlightid(id);
		fli.setName(f.getName());
		fli.setDate(f.getDate());
		fli.setSource(f.getSource());
		fli.setDestination(f.getDestination());
		fli.setCapacity(f.getCapacity());
		fli.setDuration(f.getDuration());
		fli.setPrice(f.getPrice());
		flightrepo.save(fli);          
		
		
	}
	public void deleteFlight(int id) {
		List<Booking> flightbook = bookservice.getAllBookingOfFlight(id);
		bookrepo.deleteAll(flightbook);
		flightrepo.delete(flightrepo.findByFlightid(id));
	}

	public List<Flight> getflights(String source, String destination) {
		// TODO Auto-generated method stub
		return flightrepo.findBySourceAndDestination(source, destination);
	}

}
