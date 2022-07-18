package com.wipro.bank.util;

public class ResponseMessage {

	private String message;
	private Integer statusCode;
	private Object data;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}

	public ResponseMessage(String message, Integer statusCode, Object data) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.data = data;
	}
	public ResponseMessage( Object data,Integer statusCode) {
		super();
		this.statusCode = statusCode;
		this.data = data;
	}
	public ResponseMessage(String message, Integer statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}

	public ResponseMessage() {
		super();
	}

}
