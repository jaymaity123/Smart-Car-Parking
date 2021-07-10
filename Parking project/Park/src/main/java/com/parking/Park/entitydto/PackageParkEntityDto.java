package com.parking.Park.entitydto;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PackageParkEntityDto {
	

	private int packId;
	@NotEmpty(message = "Package name cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid Package Name")
	private String packName;
	
	@FutureOrPresent(message = "Date cannot be past")
	@DateTimeFormat(pattern="yyyy-MM-dd" )
	@JsonFormat(pattern="yyyy-MM-dd")
	private  LocalDate  packDate;
	
	@NotEmpty(message = "Loaction cannot be left blank or null")
	@Size(min = 2,max = 30,message = "Invalid Loaction Name")
	private String location;
	
	@NotEmpty(message = "Building cannot be left blank or null")
	@Size(min = 2,max = 30,message = "Invalid Building Name")
	private String building;
	

	
	private int availableSlots;
	

	@Positive
	@Min(0)
	private int totalSlots;
	
	private boolean status;
	
	@Positive
	@Min(0)
	private int cost;

	public int getPackId() {
		return packId;
	}

	public void setPackId(int packId) {
		this.packId = packId;
	}

	public String getPackName() {
		return packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	
	public LocalDate getPackDate() {
		return packDate;
	}

	public void setPackDate(LocalDate packDate) {
		this.packDate = packDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public int getAvailableSlots() {
		return availableSlots;
	}

	public void setAvailableSlots(int availableSlots) {
		this.availableSlots = availableSlots;
	}

	public int getTotalSlots() {
		return totalSlots;
	}

	public void setTotalSlots(int totalSlots) {
		this.totalSlots = totalSlots;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public PackageParkEntityDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "PackageParkEntityDto [packId=" + packId + ", packName=" + packName + ", packDate=" + packDate
				+ ", location=" + location + ", building=" + building + ", availableSlots=" + availableSlots
				+ ", totalSlots=" + totalSlots + ", status=" + status + ", cost=" + cost + "]";
	}

	

	
}
