package com.parking.Park.dto;
import lombok.Data;

@Data
public class Purchaserdto {
	
	private int PurchaserId;
	private String purchaserName;
	private String address;
	private String mobileNo;
	public int getPurchaserId() {
		return PurchaserId;
	}
	public void setPurchaserId(int purchaserId) {
		PurchaserId = purchaserId;
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
		return "Purchaserdto [PurchaserId=" + PurchaserId + ", purchaserName=" + purchaserName + ", address=" + address
				+ ", mobileNo=" + mobileNo + "]";
	}
	
	

}
