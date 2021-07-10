package com.parking.Park.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class BookingPark {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	
	@ApiModelProperty(name = "BookingDate", value = "Date cannot be past")
	@Column
	@FutureOrPresent(message="Date cannot be in Past")
	private LocalDate bookingDate;
	
	
	@ApiModelProperty(name = "Package", value = "Contains package information")
	@OneToOne
	@JoinColumn(name = "Package_park", referencedColumnName = "packId")
	@Valid
	private PackagePark pack;
	
	@ApiModelProperty(name = "UserId", value = "Contains positive digit user id")
	@Column
	@Positive
	private int userId;
	
	@ApiModelProperty(name = "Total Slots", value = "Holds positive value")
	@Column
	@Positive
	@Min(1)
	private int bookSlots;
	
	@Column
	@ApiModelProperty(name = "ArrivalTime", value = "Contains arrival time")
	@DateTimeFormat(pattern="hh:mm:ss" )
	@JsonFormat(pattern="HH:mm:ss")
	private  LocalTime   arrivalTime;
	
	@ApiModelProperty(name = "Payment", value = "Contains payment details")
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Payment_park", referencedColumnName = "paymentId")
	@Valid
	private PaymentDetailsPark payment;
	
	public BookingPark(int bookingId, @Valid PackagePark pack, @Positive int userId, @Positive @Min(1) int bookSlots,
			LocalTime arrivalTime, @Valid PaymentDetailsPark payment) {
		super();
		this.bookingId = bookingId;
		this.pack = pack;
		this.userId = userId;
		this.bookSlots = bookSlots;
		this.arrivalTime = arrivalTime;
		this.payment = payment;
	}

	public BookingPark() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookingId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingPark other = (BookingPark) obj;
		if (bookingId != other.bookingId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookingPark [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", pack=" + pack + ", userId="
				+ userId + ", bookSlots=" + bookSlots + ", arrivalTime=" + arrivalTime + ", payment=" + payment + "]";
	}

	
}
