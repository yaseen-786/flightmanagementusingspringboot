package com.citiustech.flightmanagementusingspringboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.flightmanagementusingspringboot.dao.BookingRepository;
import com.citiustech.flightmanagementusingspringboot.dao.CustomerRepository;
import com.citiustech.flightmanagementusingspringboot.dao.FlightRepository;
import com.citiustech.flightmanagementusingspringboot.models.Booking;
import com.citiustech.flightmanagementusingspringboot.models.Customer;
import com.citiustech.flightmanagementusingspringboot.models.Flight;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookrepo;
	
	@Autowired
	private CustomerRepository custrepo;
	
	@Autowired
	private FlightRepository flightrepo;
	
	public Booking insert(int custid,int flightid,Booking b) {
		Customer customer = custrepo.findByCustid(custid);
		Flight flight = flightrepo.findByFlightid(flightid);
	
		if(customer!= null || flight!= null) {
			
			b.setCust(customer);
			b.setFlight(flight);
			b.setAmount(flight.getPrice()*b.getNoofticket());
			b.setSeatno(custid+flightid+b.getNoofticket());
			bookrepo.save(b);
			flightrepo.updateFlightCapacity(flight.getCapacity()-b.getNoofticket(), flightid);
			return b;
		}
		return b;
	
	}

	public void cancelFlight(int id) {
		// TODO Auto-generated method stub
		bookrepo.delete(bookrepo.findByBookid(id));
		
	}
	public List<Booking> getAllBookingOfCustomer(int id){
		List<Booking> custbook = new ArrayList<>();
		List<Booking> allbooking = bookrepo.findAll();
		for(Booking b:allbooking) {
			if(b.getCust().getCustid()==id) {
				custbook.add(b);
			}
		}
		return custbook;
	}
	public List<Booking> getAllBookingOfFlight(int id){
		List<Booking> flightbook = new ArrayList<>();
		List<Booking> allbooking = bookrepo.findAll();
		for(Booking b:allbooking) {
			if(b.getFlight().getFlightid()==id) {
				flightbook.add(b);
			}
		}
		return flightbook;
	}

	public Booking getBookingById(int id) {
		// TODO Auto-generated method stub
		return bookrepo.findByBookid(id);
	}

	public List<Booking> getAllBooking() {
		// TODO Auto-generated method stub
		return bookrepo.findAll();
	}
}
