package com.parking.Park.entitydto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.parking.Park.entities.PackagePark;
import com.parking.Park.entities.PaymentDetailsPark;



public class BookingParkEntityDto {
	
	private int bookingId;
	@FutureOrPresent(message="Date cannot be in Past")
	private LocalDate bookingDate;
	@Valid
	private PackagePark pack;
	@Positive
	private int userId;
	@DateTimeFormat(pattern="hh:mm:ss" )
	@JsonFormat(pattern="HH:mm:ss")
	private  LocalTime   arrivalTime;
	@Positive
	@Min(1)
	private int bookSlots;
	@Valid
	private PaymentDetailsPark payment;
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public PackagePark getPack() {
		return pack;
	}
	public void setPack(PackagePark pack) {
		this.pack = pack;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBookSlots() {
		return bookSlots;
	}
	public void setBookSlots(int bookSlots) {
		this.bookSlots = bookSlots;
	}
	public PaymentDetailsPark getPayment() {
		return payment;
	}
	public void setPayment(PaymentDetailsPark payment) {
		this.payment = payment;
	}
	public BookingParkEntityDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	@Override
	public String toString() {
		return "BookingParkEntityDto [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", pack=" + pack
				+ ", userId=" + userId + ", arrivalTime=" + arrivalTime + ", bookSlots=" + bookSlots + ", payment="
				+ payment + "]";
	}

}
