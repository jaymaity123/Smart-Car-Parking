package com.parking.Park.dto;
import lombok.Data;

@Data
public class PaymentDetailsParkdto {

	private  int paymentId;
	
	private  String paymentMode;
	
	private  String bankName;
	
	private  String  cardNo;

	private double   netAmount;
	
	private  String  paymentStatus;

	private  int userId;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "PaymentDetailsParkdto [paymentId=" + paymentId + ", paymentMode=" + paymentMode + ", bankName="
				+ bankName + ", cardNo=" + cardNo + ", netAmount=" + netAmount + ", paymentStatus=" + paymentStatus
				+ ", userId=" + userId + "]";
	}
	
	
	
}
