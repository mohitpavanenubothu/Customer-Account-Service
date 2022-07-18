package com.wipro.bank.entity;

public class TransferFund2 {

	private Long fromAccountNumber;

	private Long toAccountNumber;

	private Double transferAmmount;

	public Long getFromAccountNumber() {
		return fromAccountNumber;
	}

	public Long getToAccountNumber() {
		return toAccountNumber;
	}

	public Double getTransferAmmount() {
		return transferAmmount;
	}

	public void setFromAccountNumber(Long fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public void setToAccountNumber(Long toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public void setTransferAmmount(Double transferAmmount) {
		this.transferAmmount = transferAmmount;
	}

	public TransferFund2(Long fromAccountNumber, Long toAccountNumber, Double transferAmmount) {
		super();
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.transferAmmount = transferAmmount;
	}

	public TransferFund2() {
		super();
	}

	@Override
	public String toString() {
		return "TransferFund2 [fromAccountNumber=" + fromAccountNumber + ", toAccountNumber=" + toAccountNumber
				+ ", transferAmmount=" + transferAmmount + "]";
	}

}
