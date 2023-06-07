package com.citiustech.flightmanagementusingspringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.flightmanagementusingspringboot.dao.BookingRepository;
import com.citiustech.flightmanagementusingspringboot.dao.CustomerRepository;
import com.citiustech.flightmanagementusingspringboot.dao.FlightRepository;
import com.citiustech.flightmanagementusingspringboot.models.Booking;
import com.citiustech.flightmanagementusingspringboot.models.Customer;
import com.citiustech.flightmanagementusingspringboot.models.Flight;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookrepo;
	
	@Autowired
	private CustomerRepository custrepo;
	
	@Autowired
	private FlightRepository flightrepo;
	
	public String insert(int custid,int flightid,Booking b) throws RazorpayException {
		Customer customer = custrepo.findByCustid(custid);
		Flight flight = flightrepo.findByFlightid(flightid);
		RazorpayClient client = new RazorpayClient("rzp_test_1xpjWBPSJeZ7mc", "QajzYi2QBvhQLvEJt7yCpJnF");
		JSONObject obj = new JSONObject();
		obj.put("amount",flight.getPrice()*b.getNoofticket()*100 );
		obj.put("currency", "INR");
		obj.put("receipt", "txn_33333");
		
		Order order = client.orders.create(obj);
		System.out.print(order);
		
		if(customer!= null || flight!= null) {
			
			b.setCust(customer);
			b.setFlight(flight);
			b.setAmount(flight.getPrice()*b.getNoofticket());
			b.setSeatno(custid+flightid+b.getNoofticket());
			b.setOrderid(order.get("id"));
			b.setStatus("ordered");
			
			if(bookrepo.save(b) == null) {
				System.out.print("booking object not saved");
				return null;
			}else {
				flightrepo.updateFlightCapacity(flight.getCapacity()-b.getNoofticket(), flightid);
				return order.toString();
//				return b;
			}
			
//			bookrepo.save(b);
			
		}
//		return b;
		return order.toString();
	
	}

	public void cancelFlight(int id,int fid,int not) {
		// TODO Auto-generated method stub
		//System.out.println(b.getFlight());
		Flight f = flightrepo.findByFlightid(fid);
		System.out.println(f);
		f.setCapacity(f.getCapacity()+not);
		System.out.println(f);
		flightrepo.save(f);
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

	public boolean payment(Object data) {
		// TODO Auto-generated method stub
		System.out.println(data);
		return false;
	}
}
