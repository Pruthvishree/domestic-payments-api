package com.cg.openbanking.payment.domesticPaymentAPI.request;

import java.util.Date;

import javax.validation.constraints.Null;

public class PaymentResponse {
	@Null
	private String domesticPaymentId;
	
	@Null
	private String status;
	
	@Null
	private Date creationDateTime;
	
	@Null
	private Date statusUpdateDateTime;
	
	
	private Data data;

	
	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public String getDomesticPaymentId() {
		return domesticPaymentId;
	}

	public void setDomesticPaymentId(String domesticPaymentId) {
		this.domesticPaymentId = domesticPaymentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(Date creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public Date getStatusUpdateDateTime() {
		return statusUpdateDateTime;
	}

	public void setStatusUpdateDateTime(Date statusUpdateDateTime) {
		this.statusUpdateDateTime = statusUpdateDateTime;
	}

	@Override
	public String toString() {
		return "ResponseData [domesticPaymentId=" + domesticPaymentId + ", status=" + status + ", creationDateTime="
				+ creationDateTime + ", statusUpdateDateTime=" + statusUpdateDateTime + ", data=" + data + "]";
	}

	
	
}
