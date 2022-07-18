package com.wipro.bank.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "CustomerDetails")
public class Customer implements Serializable {

	private static final long serialVersionUID = 6407262050022168848L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	@Column(name = "accountHolderName")
	private String accountHolderName;

	@Column(name = "AadharNo")
	private String aadharNo;

	@Column(name = "address")
	private String address;

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Account> account;

	public Long getCustomerId() {
		return customerId;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public String getAddress() {
		return address;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	public Customer(Long customerId, String accountHolderName, String aadharNo, String address, List<Account> account) {
		super();
		this.customerId = customerId;
		this.accountHolderName = accountHolderName;
		this.aadharNo = aadharNo;
		this.address = address;
		this.account = account;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", accountHolderName=" + accountHolderName + ", aadharNo="
				+ aadharNo + ", address=" + address + ", account=" + account + "]";
	}

}
