package com.citiustech.flightmanagementusingspringboot.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightid;
	@Column(unique =true)
	private String name;
	private String date;
	private String source;
	private String destination;
	private Float price;
	private Float duration;
	private Integer capacity;
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Flight(int flightid, String name, String date, String source, String destination, Float price,
			Float duration, Integer capacity) {
		super();
		this.flightid = flightid;
		this.name = name;
		this.date = date;
		this.source = source;
		this.destination = destination;
		this.price = price;
		this.duration = duration;
		this.capacity = capacity;
	}
	public int getFlightid() {
		return flightid;
	}
	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name.toUpperCase();
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source.toLowerCase();
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination.toLowerCase();
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getDuration() {
		return duration;
	}
	public void setDuration(Float duration) {
		this.duration = duration;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return "Flight [flightid=" + flightid + ", name=" + name + ", date=" + date + ", source=" + source
				+ ", destination=" + destination + ", price=" + price + ", duration=" + duration + ", capacity="
				+ capacity + "]";
	}
	
	

}
