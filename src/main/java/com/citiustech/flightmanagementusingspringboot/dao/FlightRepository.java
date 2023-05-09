package com.citiustech.flightmanagementusingspringboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citiustech.flightmanagementusingspringboot.models.Flight;

import jakarta.transaction.Transactional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
	public Flight findByName(int flightid);
	public Flight findByFlightid(int id);
	public List<Flight> findBySourceAndDestination(String source,String destination);
	@Query("SELECT f.source FROM Flight f")
	public List<String> getAllSource();
	
	@Query("SELECT f.destination FROM Flight f")
	public List<String> getAllDestination();
	
	@Modifying
	@Transactional
	@Query("UPDATE Flight f SET f.capacity =:capacity where f.flightid =:flightid  ")
	public void updateFlightCapacity(int capacity,int flightid);
	
}
