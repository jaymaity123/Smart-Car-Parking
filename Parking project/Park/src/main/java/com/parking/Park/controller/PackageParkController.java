package com.parking.Park.controller;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.Park.dto.PackageParkdto;
import com.parking.Park.dto.Purchaserdto;
import com.parking.Park.entities.PackagePark;
import com.parking.Park.entities.Purchaser;
import com.parking.Park.entitydto.PackageParkEntityDto;
import com.parking.Park.entitydto.PurchaserEntityDto;
import com.parking.Park.exception.PackageNotFoundException;
import com.parking.Park.exception.PurchaserNotFoundException;
import com.parking.Park.service.IPackageParkService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/package")
@Api(value = "Parking System")
public class PackageParkController {
	@Autowired
	IPackageParkService packageService;
	@Autowired
	private ModelMapper modelMapper;
	
	
	@ApiOperation(value = "Package Post mapping to add package", response = PackagePark.class)
	@PostMapping("/add")
	public ResponseEntity<PackageParkdto> addingPackage(@RequestBody @Valid PackageParkEntityDto requestpack)
			throws PackageNotFoundException {

		PackagePark actualpack = modelMapper.map(requestpack, PackagePark.class);
		PackageParkdto responsepack = modelMapper.map(this.packageService.addPackage(actualpack), PackageParkdto.class);
		return new ResponseEntity<>(responsepack, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Package Delete mapping to delete package", response = PackagePark.class)
	@DeleteMapping("/delete/{packageId}")
	public ResponseEntity<PackageParkdto> deletingPackage(@PathVariable int packageId) throws PackageNotFoundException
	{
		
	PackageParkdto responsepack = modelMapper.map(this.packageService.deletePackage(packageId), PackageParkdto.class);
	if (responsepack != null) {
		return new ResponseEntity<>(responsepack, HttpStatus.OK);
	} else {
		return new ResponseEntity<>(responsepack, HttpStatus.BAD_REQUEST);
	}
	}
	
	@ApiOperation(value = "Package Get mapping to fetch all packages for a location", response = List.class)
	@GetMapping("/location/{location}")
	public ResponseEntity<List<PackageParkdto>> viewAllPackagesbyLocation(@PathVariable String location) throws PackageNotFoundException{
		
		List<PackagePark> packList = this.packageService.searchPackagebyLocation(location);
		List<PackageParkdto> packDtoList = new ArrayList<>();
		for (PackagePark p : packList) {
			PackageParkdto packdto = modelMapper.map(p, PackageParkdto.class);
			packDtoList.add(packdto);

		}
		if (!(packDtoList.isEmpty())) {

			return new ResponseEntity<>(packDtoList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(packDtoList, HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "Package Get mapping to fetch package by package name", response = PackagePark.class)
	@GetMapping("/building/{building}")
	public ResponseEntity<PackageParkdto> searchingPackagebyBuilding(@PathVariable String building)
			throws PackageNotFoundException {
		PackageParkdto responsepack = modelMapper.map(this.packageService.searchPackagebyBuilding(building), PackageParkdto.class);
		if (responsepack != null) {
			return new ResponseEntity<>(responsepack, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responsepack, HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "Package Get mapping to fetch all packages", response = List.class)
	@GetMapping("/all")
	public  ResponseEntity<List<PackageParkdto>> viewAllPackages()
	{
		   List<PackagePark> packList = this.packageService.viewAllPackages();
			List<PackageParkdto> packDtoList = new ArrayList<>();
			for (PackagePark p : packList) {
				PackageParkdto packdto = modelMapper.map(p, PackageParkdto.class);
				packDtoList.add(packdto);
			}
			if (!(packDtoList.isEmpty())) {
				return new ResponseEntity<>(packDtoList, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(packDtoList, HttpStatus.BAD_REQUEST);
			}
	}
	
	@ApiOperation(value = "Package Put mapping to update Package", response = PackagePark.class)
	@PutMapping("/update")
	public ResponseEntity<PackageParkdto> updatePurchaser(@RequestBody @Valid PackageParkEntityDto requestPack)
			throws PackageNotFoundException {

		PackagePark actualPack = modelMapper.map(requestPack, PackagePark.class);
		PackageParkdto responsePack = modelMapper.map(this.packageService.updatePackage(actualPack), PackageParkdto.class);

		if (responsePack != null) {
			return new ResponseEntity<>(responsePack, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responsePack, HttpStatus.BAD_REQUEST);
		}
	}

}
