package com.parking.Park.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class PaymentDetailsPark {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int paymentId;
	
	@ApiModelProperty(name = "PaymentMode", value = "Cannot be empty, holds min of 2 max of 15 characters")
	@Column
	@NotEmpty(message = "Payment Mode cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid Payment Mode")
	private  String paymentMode;
	
	@ApiModelProperty(name = "BankName", value = "Cannot be empty, holds min of 3 characters")
	@Column
	@NotEmpty(message = "Bank Name cannot be left blank or null")
	@Size(min = 3,message = "Invalid Bank Name")
	private  String bankName;
	
	@ApiModelProperty(name = "CardNumber", value = "Contains card number")
	@Column
	@Pattern(regexp="(^$|[0-9]{16})", message ="Enter 16 digit Card number")
	private  String  cardNo;
	
	@Column
	private double   netAmount;
	
	@ApiModelProperty(name = "PaymentStatus", value = "Cannot be empty")
	@Column
	@NotEmpty(message = "Payment status cannot be left blank or null")
	private  String  paymentStatus;
	
	@ApiModelProperty(name = "UserId", value = "Contains valid user id and must be positive")
	@Column
	@Positive
	@Min(0)
	private  int userId;
	
	
	public PaymentDetailsPark() {
		super();

	}
	public PaymentDetailsPark(int paymentId, String paymentMode, String bankName, String cardNo, double netAmount,
			String paymentStatus, int userId) {
		super();
		this.paymentId = paymentId;
		this.paymentMode = paymentMode;
		this.bankName = bankName;
		this.cardNo = cardNo;
		this.netAmount = netAmount;
		this.paymentStatus = paymentStatus;
		this.userId = userId;
	}
	/**
	 * @return the paymentId
	 */
	public int getPaymentId() {
		return paymentId;
	}
	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	/**
	 * @return the paymentMode
	 */
	public String getPaymentMode() {
		return paymentMode;
	}
	/**
	 * @param paymentMode the paymentMode to set
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * @return the cardNo
	 */
	public String getCardNo() {
		return cardNo;
	}
	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	/**
	 * @return the netAmount
	 */
	public double getNetAmount() {
		return netAmount;
	}
	/**
	 * @param netAmount the netAmount to set
	 */
	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}
	/**
	 * @return the paymentStatus
	 */
	public String getPaymentStatus() {
		return paymentStatus;
	}
	/**
	 * @param paymentStatus the paymentStatus to set
	 */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + paymentId;
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
		PaymentDetailsPark other = (PaymentDetailsPark) obj;
		if (paymentId != other.paymentId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PaymentDetails [paymentId=" + paymentId + ", paymentMode=" + paymentMode + ", bankName=" + bankName
				+ ", cardNo=" + cardNo + ", netAmount=" + netAmount + ", paymentStatus=" + paymentStatus + ", userId="
				+ userId + "]";
	}
	

}
