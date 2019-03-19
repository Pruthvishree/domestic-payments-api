package com.cg.openbanking.payment.domesticPaymentAPI.Exception;

import java.util.Date;

public class ExceptionResponse {
	private String message;
	private String httpCode;
	private Date requestDate;
	
	
	public ExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExceptionResponse(String message, String httpCode, Date requestDate) {
		super();
		this.message = message;
		this.httpCode = httpCode;
		this.requestDate = requestDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(String httpCode) {
		this.httpCode = httpCode;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	@Override
	public String toString() {
		return "ExceptionResponse [message=" + message + ", httpCode=" + httpCode + ", requestDate=" + requestDate
				+ "]";
	}
	
	
	
	
}
