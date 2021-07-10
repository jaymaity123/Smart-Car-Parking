package com.parking.Park.entitydto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



public class PurchaserEntityDto extends UserParkEntityDto {
	
	@NotEmpty(message = "Purchaser name cannot be left blank or null")
	@Size(min = 3, max = 20, message = "Invalid Purchaser Name")
	private String purchaserName;
	
	@NotEmpty(message = "Address cannot be left blank or null")
	@Size(min = 5, message = "Invalid Address")
	private String address;
	
	
	@NotEmpty(message = "Mobile number cannot be left blank or null")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Enter 10 digit mobile number")
	private String mobileNo;


	public PurchaserEntityDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public String getPurchaserName() {
		return purchaserName;
	}




	public void setPurchaserName(String purchaserName) {
		this.purchaserName = purchaserName;
	}




	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}




	@Override
	public String toString() {
		return "PurchaserEntityDto [purchaserName=" + purchaserName + ", address=" + address + ", mobileNo=" + mobileNo
				+ "]";
	}


	
	

}