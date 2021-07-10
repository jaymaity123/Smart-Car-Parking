package com.parking.Park.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
@Entity
public class PackagePark {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int packId;
	
	@ApiModelProperty(name = "PackageName", value = "Cannot be empty, holds min of 2 max of 15 characters")
	@Column
	@NotEmpty(message = "Package name cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid Package Name")
	private String packName;
	
	@ApiModelProperty(name = "DepartureTime", value = "Date cannot be past")
	@Column
	@FutureOrPresent(message = "Date cannot be past")
	@DateTimeFormat(pattern="yyyy-MM-dd" )
	@JsonFormat(pattern="yyyy-MM-dd")
	private  LocalDate  packDate;
	
	@ApiModelProperty(name = "Location", value = "Cannot be empty, holds min of 2 max of 15 characters")
	@Column
	@NotEmpty(message = "Loaction cannot be left blank or null")
	@Size(min = 2,max = 30,message = "Invalid Loaction Name")
	private String location;
	
	@ApiModelProperty(name = "Building", value = "Cannot be empty, holds min of 2 max of 15 characters")
	@Column
	@NotEmpty(message = "Building cannot be left blank or null")
	@Size(min = 2,max = 30,message = "Invalid Building Name")
	private String building;
	
	@ApiModelProperty(name = "Available Slots", value = "Holds positive value")
	@Column
	private int availableSlots;
	
	@ApiModelProperty(name = "Total Slots", value = "Holds positive value")
	@Column
	@Positive
	@Min(0)
	private int totalSlots;
	
	@Column
	private boolean status;
	
	@ApiModelProperty(name = "Cost", value = "Holds positive value")
	@Column
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

	public PackagePark() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + packId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PackagePark other = (PackagePark) obj;
		if (packId != other.packId)
			return false;
		return true;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "PackagePark [packId=" + packId + ", packName=" + packName + ", packDate=" + packDate + ", location="
				+ location + ", building=" + building + ", availableSlots=" + availableSlots + ", totalSlots="
				+ totalSlots + ", status=" + status + ", cost=" + cost + "]";
	}

	
}
