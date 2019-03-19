package com.cg.openbanking.payment.domesticPaymentAPI.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="data")
public class Data implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	
	
	@Column(name="expiration_date_time")
	private String expirationDateTime;
	
	@Column(name="consent_id")
	private String consentId;
	
	@Column(name="creation_date_time")
	private String creationDateTime;
	
	@Column(name="status")
	private String status;
	
	@Column(name="status_update_date_time")
	private String statusUpdateDateTime;
	
	@Column(name="reference")
	private String reference;

	public String getExpirationDateTime() {
		return expirationDateTime;
	}

	public void setExpirationDateTime(String expirationDateTime) {
		this.expirationDateTime = expirationDateTime;
	}

	public String getConsentId() {
		return consentId;
	}

	public void setConsentId(String consentId) {
		this.consentId = consentId;
	}

	public String getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(String creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusUpdateDateTime() {
		return statusUpdateDateTime;
	}

	public void setStatusUpdateDateTime(String statusUpdateDateTime) {
		this.statusUpdateDateTime = statusUpdateDateTime;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Override
	public String toString() {
		return "Data [expirationDateTime=" + expirationDateTime + ", consentId=" + consentId + ", creationDateTime="
				+ creationDateTime + ", status=" + status + ", statusUpdateDateTime=" + statusUpdateDateTime
				+ ", reference=" + reference + "]";
	}

	
	
}
