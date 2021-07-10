package com.parking.Park.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.Park.entities.BookingPark;
import com.parking.Park.exception.BookingNotFoundException;
import com.parking.Park.repository.IBookingParkRepository;

@Service
public class BookingParkServiceImpl implements IBookingParkService {

	
	Logger log = LoggerFactory.getLogger(BookingParkServiceImpl.class);

	@Autowired
	IBookingParkRepository bookingRepository;
	
	@Override
	@Transactional
	
	public BookingPark makeBooking(BookingPark booking) {
			try {
			if(booking.getPack().getAvailableSlots()==0) {
				throw new BookingNotFoundException("Booking not possible");
				}
			else {
				booking.setBookingDate(LocalDate.now());
				booking.getPayment().setNetAmount(booking.getPack().getCost());
				bookingRepository.save(booking);
				}
		} catch (Exception e) {
			log.error("Booking exp:", e);
		}
		return booking;
	}

	@Override
	public BookingPark cancelBooking(int bookingId) throws BookingNotFoundException {
		try {

			Optional<BookingPark> opt = bookingRepository.findById(bookingId);
			if (opt.isPresent()) {
				bookingRepository.deleteById(bookingId);
				return opt.get();
			} else {
				throw new BookingNotFoundException("No booking found for cancel!");
			}
		} catch (Exception e) {

			throw new BookingNotFoundException("No booking found for cancel!");
		}
	}
	
	

	@Override
	public BookingPark viewBooking(int bookingId) throws BookingNotFoundException {
		try {
			Optional<BookingPark> opt = bookingRepository.findById(bookingId);
			if (opt.isPresent()) {
				return  opt.get();
				
			} else {
				throw new BookingNotFoundException("No booking found for view booking!");
			}
		} catch (Exception e) {

			throw new BookingNotFoundException("No booking found for view booking!");
		}
	}

	@Override
	public List<BookingPark> viewAllBookings() {
		List<BookingPark> bookingList = null;
		try {
			bookingList = bookingRepository.findAll();

		} catch (Exception e) {
			log.error("Booking list exception:", e);
		}
		return bookingList;
	}

}
