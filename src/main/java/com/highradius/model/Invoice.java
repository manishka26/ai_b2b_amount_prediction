package com.highradius.model;

public class Invoice {
	int serialNo, customerOrderId, companyCode, customerNumber, salesOrg, soldToParty;
	String distributionChannel, division, orderCreationDate, orderCurrency, purchaseOrderType, orderCreationTime, creditControlArea, requestedDeliveryDate, creditStatus;
	float amountInUSD, orderAmount, releasedCreditValue;
	long uniqueCustId;
	
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public int getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	public int getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}
	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	public int getSalesOrg() {
		return salesOrg;
	}
	public void setSalesOrg(int salesOrg) {
		this.salesOrg = salesOrg;
	}
	public int getSoldToParty() {
		return soldToParty;
	}
	public void setSoldToParty(int soldToParty) {
		this.soldToParty = soldToParty;
	}
	public String getDistributionChannel() {
		return distributionChannel;
	}
	public void setDistributionChannel(String distributionChannel) {
		this.distributionChannel = distributionChannel;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getOrderCreationDate() {
		return orderCreationDate;
	}
	public void setOrderCreationDate(String orderCreationDate) {
		this.orderCreationDate = orderCreationDate;
	}
	public String getOrderCurrency() {
		return orderCurrency;
	}
	public void setOrderCurrency(String orderCurrency) {
		this.orderCurrency = orderCurrency;
	}
	public String getPurchaseOrderType() {
		return purchaseOrderType;
	}
	public void setPurchaseOrderType(String purchaseOrderType) {
		this.purchaseOrderType = purchaseOrderType;
	}
	public String getOrderCreationTime() {
		return orderCreationTime;
	}
	public void setOrderCreationTime(String orderCreationTime) {
		this.orderCreationTime = orderCreationTime;
	}
	public String getCreditControlArea() {
		return creditControlArea;
	}
	public void setCreditControlArea(String creditControlArea) {
		this.creditControlArea = creditControlArea;
	}
	public String getRequestedDeliveryDate() {
		return requestedDeliveryDate;
	}
	public void setRequestedDeliveryDate(String requestedDeliveryDate) {
		this.requestedDeliveryDate = requestedDeliveryDate;
	}
	public String getCreditStatus() {
		return creditStatus;
	}
	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}
	public float getAmountInUSD() {
		return amountInUSD;
	}
	public void setAmountInUSD(float amountInUSD) {
		this.amountInUSD = amountInUSD;
	}
	public float getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(float orderAmount) {
		this.orderAmount = orderAmount;
	}
	public float getReleasedCreditValue() {
		return releasedCreditValue;
	}
	public void setReleasedCreditValue(float releasedCreditValue) {
		this.releasedCreditValue = releasedCreditValue;
	}
	public long getUniqueCustId() {
		return uniqueCustId;
	}
	public void setUniqueCustId(long uniqueCustId) {
		this.uniqueCustId = uniqueCustId;
	}
	
	public Invoice(int serialNo, int customerOrderId, int salesOrg, String distributionChannel, String division, float releasedCreditValue, String purchaseOrderType, 
			int companyCode, String orderCreationDate, String orderCreationTime, String creditControlArea, int soldToParty, float orderAmount, 
			String requestedDeliveryDate, String orderCurrency, String creditStatus, int customerNumber, float amountInUSD, long uniqueCustId) {
		super();
		this.serialNo = serialNo;
		this.customerOrderId = customerOrderId;
		this.companyCode = companyCode;
		this.customerNumber = customerNumber;
		this.salesOrg = salesOrg;
		this.soldToParty = soldToParty;
		this.distributionChannel = distributionChannel;
		this.division = division;
		this.orderCreationDate = orderCreationDate;
		this.orderCurrency = orderCurrency;
		this.purchaseOrderType = purchaseOrderType;
		this.orderCreationTime = orderCreationTime;
		this.creditControlArea = creditControlArea;
		this.requestedDeliveryDate = requestedDeliveryDate;
		this.creditStatus = creditStatus;
		this.amountInUSD = amountInUSD;
		this.orderAmount = orderAmount;
		this.releasedCreditValue = releasedCreditValue;
		this.uniqueCustId = uniqueCustId;
	}
	
	@Override
	public String toString() {
		return "Invoice [serialNo=" + serialNo + ", customerOrderId=" + customerOrderId + ", companyCode=" + companyCode
				+ ", customerNumber=" + customerNumber + ", salesOrg=" + salesOrg + ", soldToParty=" + soldToParty
				+ ", distributionChannel=" + distributionChannel + ", division=" + division + ", orderCreationDate="
				+ orderCreationDate + ", orderCurrency=" + orderCurrency + ", purchaseOrderType=" + purchaseOrderType
				+ ", orderCreationTime=" + orderCreationTime + ", creditControlArea=" + creditControlArea
				+ ", requestedDeliveryDate=" + requestedDeliveryDate + ", creditStatus=" + creditStatus
				+ ", amountInUSD=" + amountInUSD + ", orderAmount=" + orderAmount + ", releasedCreditValue="
				+ releasedCreditValue + ", uniqueCustId=" + uniqueCustId + "]";
	}
	
}