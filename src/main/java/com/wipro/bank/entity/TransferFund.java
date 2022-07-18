package com.wipro.bank.entity;

public class TransferFund {

	private long from;
	private long to;
	private int fund;

	public long getFrom() {
		return from;
	}

	public void setFrom(long from) {
		this.from = from;
	}

	public long getTo() {
		return to;
	}

	public void setTo(long to) {
		this.to = to;
	}

	public int getFund() {
		return fund;
	}

	public void setFund(int fund) {
		this.fund = fund;
	}

	public TransferFund(long from, long to, int fund) {
		super();
		this.from = from;
		this.to = to;
		this.fund = fund;
	}

	@Override
	public String toString() {
		return "TransferFund [from=" + from + ", to=" + to + ", fund=" + fund + "]";
	}

	public TransferFund() {
		super();
		// TODO Auto-generated constructor stub
	}

}
