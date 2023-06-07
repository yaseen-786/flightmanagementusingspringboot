package com.citiustech.flightmanagementusingspringboot.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookid;
	@OneToOne
	private Customer cust;
	@OneToOne
	private Flight flight;
	private Integer noofticket;
	private String orderid;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getNoofticket() {
		return noofticket;
	}
	public void setNoofticket(Integer noofticket) {
		this.noofticket = noofticket;
	}
	private Float amount;
	private Integer seatno;
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(Integer bookid, Customer cust, Flight flight, Float amount, Integer seatno,Integer noofticket,String orderid,String status) {
		super();
		this.bookid = bookid;
		this.cust = cust;
		this.flight = flight;
		this.amount = amount;
		this.seatno = seatno;
		this.noofticket = noofticket;
		this.orderid = orderid;
		this.status = status;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Integer getSeatno() {
		return seatno;
	}
	public void setSeatno(Integer seatno) {
		this.seatno = seatno;
	}
	@Override
	public String toString() {
		return "Booking [bookid=" + bookid + ", cust=" + cust + ", flight=" + flight + ", noofticket=" + noofticket
				+ ", orderid=" + orderid + ", amount=" + amount + ", seatno=" + seatno + ", status=" + status+"]";
	}
	
	
	
}
