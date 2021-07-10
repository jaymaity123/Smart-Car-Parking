package com.parking.Park.service;

import java.util.List;

import com.parking.Park.entities.BookingPark;
import com.parking.Park.exception.BookingNotFoundException;

public interface IBookingParkService {
	
	public  BookingPark  makeBooking(BookingPark booking);
	public  BookingPark  cancelBooking(int bookingId) throws BookingNotFoundException;
	public  BookingPark  viewBooking(int bookingId)throws BookingNotFoundException;
	public List<BookingPark> viewAllBookings();

}
