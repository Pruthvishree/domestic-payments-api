package com.cg.openbanking.payment.domesticPaymentAPI.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="payments")
public class Payments implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO )
	@Column(name="payment_id")
	private String paymentId;
	
	@Column(name="consent_id")
	private String consent_id;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="status")
	private String status;
	
	@Column(name="status_update_date")
	private Date statusUpdationDate;
	
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "consent_id", referencedColumnName = "consent_id", insertable = false, updatable = false)
	private Consents consents;  
	
	
	
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getConsent_id() {
		return consent_id;
	}
	public void setConsent_id(String consent_id) {
		this.consent_id = consent_id;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getStatusUpdationDate() {
		return statusUpdationDate;
	}
	public void setStatusUpdationDate(Date statusUpdationDate) {
		this.statusUpdationDate = statusUpdationDate;
	}
	@Override
	public String toString() {
		return "Payments [paymentId=" + paymentId + ", consent_id=" + consent_id + ", creationDate=" + creationDate
				+ ", status=" + status + ", statusUpdationDate=" + statusUpdationDate + "]";
	}
	
}
