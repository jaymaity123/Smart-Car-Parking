package com.parking.Park.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PackageParkdto {
	private int packId;
	
	private String packName;

	private  LocalDate  packDate;

	private String location;
	
	private String building;

	private int availableSlots;
	
	private int totalSlots;
	
	private boolean status;
	
	private int cost;
	

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

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

	@Override
	public String toString() {
		return "PackageParkdto [packId=" + packId + ", packName=" + packName + ", packDate=" + packDate + ", location="
				+ location + ", building=" + building + ", availableSlots=" + availableSlots + ", totalSlots="
				+ totalSlots + ", status=" + status + ", cost=" + cost + "]";
	}

	
	
}
