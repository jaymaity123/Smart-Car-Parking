package com.parking.Park.entitydto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
public class PaymentDetailsParkEntityDto {

	
	private  int paymentId;
	
	@NotEmpty(message = "Payment Mode cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid Payment Mode")
	private  String paymentMode;
	
	@NotEmpty(message = "Bank Name cannot be left blank or null")
	@Size(min = 3,message = "Invalid Bank Name")
	private  String bankName;
	
	@Pattern(regexp="(^$|[0-9]{16})", message ="Enter 16 digit Card number")
	private  String  cardNo;
	
	private double   netAmount;
	
	@NotEmpty(message = "Payment status cannot be left blank or null")
	private  String  paymentStatus;
	
	@Positive
	@Min(0)
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

	public PaymentDetailsParkEntityDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PaymentDetailsParkEntityDto [paymentId=" + paymentId + ", paymentMode=" + paymentMode + ", bankName="
				+ bankName + ", cardNo=" + cardNo + ", netAmount=" + netAmount + ", paymentStatus=" + paymentStatus
				+ ", userId=" + userId + "]";
	}
	

}
