package com.parking.Park.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.Park.entities.BookingPark;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingParkRepository extends JpaRepository<BookingPark, Integer> {
	
	

}
