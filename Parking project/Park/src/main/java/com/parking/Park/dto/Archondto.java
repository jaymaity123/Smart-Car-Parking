package com.parking.Park.dto;

import lombok.Data;

@Data
public class Archondto {
	
	private int ArchonId;
	
	
	private String archonName;

	private String mobile;

	public int getArchonId() {
		return ArchonId;
	}

	public void setArchonId(int archonId) {
		ArchonId = archonId;
	}

	
	public String getArchonName() {
		return archonName;
	}

	public void setArchonName(String archonName) {
		this.archonName = archonName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Archondto [ArchonId=" + ArchonId + ", archonName=" + archonName + ", mobile=" + mobile + "]";
	}

	
	

}
