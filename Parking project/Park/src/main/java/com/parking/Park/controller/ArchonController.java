package com.parking.Park.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

import com.parking.Park.dto.Archondto;
import com.parking.Park.entities.Archon;
import com.parking.Park.entitydto.ArchonEntityDto;
import com.parking.Park.service.IUserParkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/archon")
@Api(value = "Parking System")
public class ArchonController {
	
	@Autowired
	IUserParkService adminService;
	@Autowired
	private ModelMapper modelMapper;

	private int userId;
	
	@ApiOperation(value = "Admin Post mapping to add user", response = Archon.class)
	@PostMapping("/add")
	public ResponseEntity<Archondto> addAdmin(@RequestBody @Valid ArchonEntityDto admin)
	{

		Archon actualAdmin = modelMapper.map(admin, Archon.class);
		System.out.println(actualAdmin);
		Archondto responseAdmin = modelMapper.map(this.adminService.addNewUser(actualAdmin), Archondto.class);
		System.out.println(responseAdmin);
		return new ResponseEntity<>(responseAdmin, HttpStatus.OK);
	}

}
