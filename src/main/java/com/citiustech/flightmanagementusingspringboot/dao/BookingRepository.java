package com.citiustech.flightmanagementusingspringboot.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.flightmanagementusingspringboot.models.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
	
	public Booking findByBookid(int id);
	public Booking findByOrderid(String orderid);

}
