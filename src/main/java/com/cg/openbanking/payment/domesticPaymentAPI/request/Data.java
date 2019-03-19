package com.cg.openbanking.payment.domesticPaymentAPI.request;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Data implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@NotEmpty(message = "consent id is required")
	private String consentId;
	
	@NotNull
	@Valid
	private Initiation initiation;
	
	
	public String getConsentId() {
		return consentId;
	}
	public void setConsentId(String consentId) {
		this.consentId = consentId;
	}
	public Initiation getInitiation() {
		return initiation;
	}
	public void setInitiation(Initiation initiation) {
		this.initiation = initiation;
	}
	@Override
	public String toString() {
		return "Data [consentId=" + consentId + ", initiation=" + initiation + "]";
	}
	
	
	
	
	
	}
