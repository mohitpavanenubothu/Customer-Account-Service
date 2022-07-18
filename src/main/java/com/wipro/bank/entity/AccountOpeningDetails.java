package com.wipro.bank.entity;

public class AccountOpeningDetails {

	private String accountNumber;

	private String accountHolderName;

	private String accountType;

	private double balanceAmount;

	private String aadharNo;

	private String address;

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public String getAccountType() {
		return accountType;
	}

	public double getBalanceAmount() {
		return balanceAmount;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AccountOpeningDetails(String accountNumber, String accountHolderName, String accountType,
			double balanceAmount, String aadharNo, String address) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
		this.balanceAmount = balanceAmount;
		this.aadharNo = aadharNo;
		this.address = address;
	}

	public AccountOpeningDetails() {
		super();
	}

}
