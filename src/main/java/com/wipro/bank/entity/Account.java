package com.wipro.bank.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Account_Master")

public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8178240169047984729L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;

	@Column(name = "AccountNumber")
	private String accountNumber;

	@Column(name = "AccountType")
	private String accountType;

	@Column(name = "BalanceAmount")
	private Double balanceAmount;

	@ManyToOne
    @JoinColumn(name = "customerId", nullable=false)
	//@JsonBackReference// to break the tree loop for entities
	private Customer customer;

	public Account() {
		super();
	}

	public Account(Long accountId, String accountNumber, String accountType, Double balanceAmount,
			Customer customer) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balanceAmount = balanceAmount;
		this.customer = customer;
	}

	public Long getAccountId() {
		return accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public Double getBalanceAmount() {
		return balanceAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", balanceAmount=" + balanceAmount + ", customer=" + customer + "]";
	}

}
