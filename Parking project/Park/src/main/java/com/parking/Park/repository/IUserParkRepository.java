package com.parking.Park.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.Park.entities.UserPark;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserParkRepository extends JpaRepository<UserPark, Integer> {
	
	

}
