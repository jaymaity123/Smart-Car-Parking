package com.parking.Park.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.Park.dto.Purchaserdto;
import com.parking.Park.entities.Purchaser;
import com.parking.Park.entitydto.PurchaserEntityDto;
import com.parking.Park.exception.PackageNotFoundException;
import com.parking.Park.exception.PurchaserNotFoundException;
import com.parking.Park.service.IPurchaserService;

import io.swagger.annotations.Api;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.modelmapper.ModelMapper;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/purchaser")
@Api(value = "Parking System")
public class PurchaserController {
	@Autowired
	IPurchaserService custService;
	@Autowired
	private ModelMapper modelMapper;
	
	@ApiOperation(value = "Purchaser Post mapping", response = PurchaserController.class)
	@PostMapping(value = "/add")
	public ResponseEntity<Purchaserdto> addPurchaser(@RequestBody @Valid PurchaserEntityDto requestCust) {

		Purchaser actualCust = modelMapper.map(requestCust, Purchaser.class);
		Purchaserdto responseCust = modelMapper.map(this.custService.addPurchaser(actualCust), Purchaserdto.class);
		return new ResponseEntity<>(responseCust, HttpStatus.OK);
	}

	
	@ApiOperation(value = "Purchaser Put mapping to update Purchaser", response = Purchaser.class)
	@PutMapping("/update")
	public ResponseEntity<Purchaserdto> updatePurchaser(@RequestBody @Valid PurchaserEntityDto requestCust)
			throws PurchaserNotFoundException {

		Purchaser actualCust = modelMapper.map(requestCust, Purchaser.class);
		Purchaserdto responseCust = modelMapper.map(this.custService.updatePurchaser(actualCust), Purchaserdto.class);

		if (responseCust != null) {
			return new ResponseEntity<>(responseCust, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseCust, HttpStatus.BAD_REQUEST);
		}
	}

	
	@ApiOperation(value = "Purchaser Delete mapping to delete Purchaser", response = Purchaser.class)
	@DeleteMapping("/delete")
	public ResponseEntity<Purchaserdto> deletePurchaser(@RequestBody @Valid PurchaserEntityDto requestCust)
			throws PurchaserNotFoundException {
		Purchaser actualCust = modelMapper.map(requestCust, Purchaser.class);
		Purchaserdto responseCust = modelMapper.map(this.custService.deletePurchaser(actualCust), Purchaserdto.class);

		if (responseCust != null) {
			return new ResponseEntity<>(responseCust, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseCust, HttpStatus.BAD_REQUEST);
		}
	}

	
	@ApiOperation(value = "Purchaser Get mapping to fetch Purchaser using Purchaser Id", response = Purchaser.class)
	@GetMapping("/view/{custid}")
	public ResponseEntity<Purchaserdto> viewPurchaser(@PathVariable int custid) throws PurchaserNotFoundException {
	Purchaserdto responseCust = modelMapper.map(this.custService.viewPurchaser(custid), Purchaserdto.class);
		if (responseCust != null) {
			return new ResponseEntity<>(responseCust, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(responseCust, HttpStatus.BAD_REQUEST);
		}
	}

	
	@ApiOperation(value = "Purchaser Get mapping to fetch all the Purchasers", response = List.class)
	@GetMapping("/view/package/{packageId}")
	public ResponseEntity<List<Purchaserdto>> viewAllPurchasers(@PathVariable int packageId)
			throws PackageNotFoundException {
	List<Purchaser> custList = this.custService.viewAllPurchasers(packageId);
		List<Purchaserdto> custDtoList = new ArrayList<>();
		for (Purchaser c : custList) {
			Purchaserdto custdto = modelMapper.map(c, Purchaserdto.class);
			custDtoList.add(custdto);
		}
		if (!(custDtoList.isEmpty())) {
			return new ResponseEntity<>(custDtoList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(custDtoList, HttpStatus.BAD_REQUEST);
		}
	}

}
