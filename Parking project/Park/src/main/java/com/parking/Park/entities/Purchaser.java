package com.parking.Park.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue(value = "3")
public class Purchaser extends UserPark {

	
	@ApiModelProperty(name = "PurchaserName", value = "Cannot be null, holds min of 3 characters and max of 20 characters")
	@Column
	@NotEmpty(message = "Purchaser name cannot be left blank or null")
	@Size(min = 3, max = 20, message = "Invalid Purchaser Name")
	private String purchaserName;
	
	@ApiModelProperty(name = "Address", value = "Cannot be null, holds min of 5 characters")
	@Column
	@NotEmpty(message = "Address cannot be left blank or null")
	@Size(min = 5, message = "Invalid Address")
	private String address;
	
	@ApiModelProperty(name = "MobileNumber", value = "Cannot be null, should be valid 10 digit mobile number")
	@Column
	@NotEmpty(message = "Mobile number cannot be left blank or null")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Enter 10 digit mobile number")
	private String mobileNo;
	

	public Purchaser() {
		super();

	}


	public Purchaser(
			@NotEmpty(message = "Purchaser name cannot be left blank or null") @Size(min = 3, max = 20, message = "Invalid Purchaser Name") String purchaserName,
			@NotEmpty(message = "Address cannot be left blank or null") @Size(min = 5, message = "Invalid Address") String address,
			@NotEmpty(message = "Mobile number cannot be left blank or null") @Pattern(regexp = "(^$|[0-9]{10})", message = "Enter 10 digit mobile number") String mobileNo) {
		super();
		this.purchaserName = purchaserName;
		this.address = address;
		this.mobileNo = mobileNo;
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
		return "Purchaser [purchaserName=" + purchaserName + ", address=" + address + ", mobileNo=" + mobileNo + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((mobileNo == null) ? 0 : mobileNo.hashCode());
		result = prime * result + ((purchaserName == null) ? 0 : purchaserName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchaser other = (Purchaser) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (mobileNo == null) {
			if (other.mobileNo != null)
				return false;
		} else if (!mobileNo.equals(other.mobileNo))
			return false;
		if (purchaserName == null) {
			if (other.purchaserName != null)
				return false;
		} else if (!purchaserName.equals(other.purchaserName))
			return false;
		return true;
	}

	
}


	
	