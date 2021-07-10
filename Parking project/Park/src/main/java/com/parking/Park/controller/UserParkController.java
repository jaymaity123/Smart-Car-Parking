package com.parking.Park.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.Park.entities.UserPark;
import com.parking.Park.exception.InvalidCredentialException;
import com.parking.Park.service.IUserParkService;

import io.swagger.annotations.Api;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(value = "Parking System")
public class UserParkController {
	
	@Autowired
	IUserParkService userService;
	
	@ApiOperation(value = "User Post mapping to add user", response = UserPark.class)
	@PostMapping("/add")
	public UserPark adduser(@RequestBody @Valid UserPark user)
	{
		this.userService.addNewUser(user);
		return user;
	}
	
	@ApiOperation(value = "User Post mapping for user signing in", response = UserPark.class)
	@PostMapping("/signin")
	public ResponseEntity<UserPark> signuser(@RequestBody @Valid UserPark user) throws InvalidCredentialException
	{
		this.userService.signIn(user);
		return new ResponseEntity<>(user, HttpStatus.OK);

	}
	
	@ApiOperation(value = "User Post mapping for user signing out", response = UserPark.class)
	@PostMapping("/signout")
	public ResponseEntity<UserPark> signoutuser(@RequestBody @Valid UserPark user) 
	{
	this.userService.signOut(user);
	return new ResponseEntity<>(user, HttpStatus.RESET_CONTENT);

	}

}
