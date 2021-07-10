package com.parking.Park.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import com.parking.Park.dto.BookingParkdto;
import com.parking.Park.dto.PackageParkdto;
import com.parking.Park.entities.BookingPark;
import com.parking.Park.entities.PackagePark;
import com.parking.Park.entities.Purchaser;
import com.parking.Park.entitydto.BookingParkEntityDto;
import com.parking.Park.exception.BookingNotFoundException;
import com.parking.Park.exception.PackageNotFoundException;
import com.parking.Park.service.IBookingParkService;
import com.parking.Park.service.IPackageParkService;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.modelmapper.ModelMapper;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/booking")
@Api(value = "Parking System")
public class BookingParkController {
	@Autowired
	IPackageParkService packageService;
	@Autowired
	IBookingParkService bookingService;
	@Autowired
	private ModelMapper modelMapper;

	@ApiOperation(value = "Booking Post mapping for booking", response = BookingPark.class)
	@PostMapping("/add")
	public ResponseEntity<BookingParkdto> makeBooking(@RequestBody @Valid BookingParkEntityDto requestBooking) throws PackageNotFoundException {

		BookingPark actualBooking = modelMapper.map(requestBooking, BookingPark.class);
		BookingParkdto responseBooking = modelMapper.map(this.bookingService.makeBooking(actualBooking), BookingParkdto.class);
		PackagePark actualpack = modelMapper.map(actualBooking.getPack(), PackagePark.class);
		int i = actualBooking.getBookSlots();
		actualpack.setAvailableSlots(actualpack.getAvailableSlots()-i);
		PackageParkdto responsepack = modelMapper.map(this.packageService.updatePackage(actualpack), PackageParkdto.class);
		return new ResponseEntity<>(responseBooking, HttpStatus.OK);

	}
	@ApiOperation(value = "Booking Delete mapping to cancel booking", response = BookingPark.class)
	@DeleteMapping("/delete/{bookingId}")
	public ResponseEntity<BookingParkdto> cancelBooking(@PathVariable int bookingId) throws BookingNotFoundException {

		BookingParkdto responseBooking = modelMapper.map(this.bookingService.cancelBooking(bookingId), BookingParkdto.class);
		if (responseBooking != null) {
			return new ResponseEntity<>(responseBooking, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseBooking, HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Booking Get mapping to fetch booking by booking id", response = BookingPark.class)
	@GetMapping("/view/{bookingId}")
	public ResponseEntity<BookingParkdto> viewBooking(@PathVariable int bookingId) throws BookingNotFoundException {

		BookingParkdto responseBooking = modelMapper.map(this.bookingService.viewBooking(bookingId), BookingParkdto.class);
		if (responseBooking != null) {
			return new ResponseEntity<>(responseBooking, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseBooking, HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "Booking Get mapping to fetch all bookings")
	@GetMapping("/view")
	public ResponseEntity<List<BookingParkdto>> viewAllBookings() {

		List<BookingPark> bookingList = this.bookingService.viewAllBookings();
		List<BookingParkdto> bookingDtoList = new ArrayList<>();
		for (BookingPark b : bookingList) {
			BookingParkdto bookingdto = modelMapper.map(b, BookingParkdto.class);
			bookingDtoList.add(bookingdto);
		}
		if (!(bookingDtoList.isEmpty())) {
			return new ResponseEntity<>(bookingDtoList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(bookingDtoList, HttpStatus.BAD_REQUEST);
		}
	}

	

}
