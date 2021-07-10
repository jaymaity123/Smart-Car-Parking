package com.parking.Park.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.parking.Park.entities.PackagePark;
import com.parking.Park.entities.PaymentDetailsPark;

import lombok.Data;

@Data
public class BookingParkdto {
	private int bookingId;
	
	private LocalDate bookingDate;
	
	
	private PackagePark pack;
	
	private int userId;
	
	private int bookSlots;
	
	private LocalTime arrivalTime;

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
	

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Override
	public String toString() {
		return "BookingParkdto [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", pack=" + pack
				+ ", userId=" + userId + ", bookSlots=" + bookSlots + ", arrivalTime=" + arrivalTime + ", payment="
				+ payment + "]";
	}
	
	
}
