package com.parking.Park.service;

import com.parking.Park.entities.UserPark;
import com.parking.Park.exception.InvalidCredentialException;

public interface IUserParkService {
	
	public  UserPark addNewUser(UserPark user);
	public UserPark signIn(UserPark user) throws InvalidCredentialException;
	public UserPark signOut(UserPark user);

}
