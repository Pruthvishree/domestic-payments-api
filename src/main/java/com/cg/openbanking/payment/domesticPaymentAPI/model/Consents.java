package com.cg.openbanking.payment.domesticPaymentAPI.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="consents")
public class Consents {
	
	
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="consent_id")
	private String consentId;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="status")
	private String status;
	
	@Column(name="status_update_date")
	private Date statusUpdationDate;
	
	private String cut_off_date;
	private String payment_amount;
	private String payment_currency;
	private String requested_execution_date;
	private String creditor_id;
	private String debtor_id;
	private String remittence_reference;
	private String remittence_unstructured;
	private String payment_context;
	private String instruction_identification;
	private String end_to_end_identification;
	private String permission;
	private String expected_execution_date;
	private String frequency;
	private String reference;
	private String first_payment_date;
	private String first_payment_amount;
	private String first_payment_currency;
	private String final_payment_amount;
	private String final_payment_currency;
	private String final_payment_date;
	private String instruction_priority;
	private String currency_of_transfer;
	private String exchange_rate;
	private String exchange_rate_currency;
	private String exchange_rate_type;
	private String exchange_rate_contract;
	private String exchange_rate_expiration_date;
	
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumns({
			@JoinColumn(name="creditor_id",referencedColumnName = "identification", insertable = false, updatable = false),
			@JoinColumn(name="debtor_id", referencedColumnName = "identification", insertable = false, updatable = false),

	}) 
	private Account account; 
	
	
	public String getConsentId() {
		return consentId;
	}
	public void setConsentId(String consentId) {
		this.consentId = consentId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getStatusUpdationDate() {
		return statusUpdationDate;
	}
	public void setStatusUpdationDate(Date statusUpdationDate) {
		this.statusUpdationDate = statusUpdationDate;
	}
	public String getCut_off_date() {
		return cut_off_date;
	}
	public void setCut_off_date(String cut_off_date) {
		this.cut_off_date = cut_off_date;
	}
	public String getPayment_amount() {
		return payment_amount;
	}
	public void setPayment_amount(String payment_amount) {
		this.payment_amount = payment_amount;
	}
	public String getPayment_currency() {
		return payment_currency;
	}
	public void setPayment_currency(String payment_currency) {
		this.payment_currency = payment_currency;
	}
	public String getRequested_execution_date() {
		return requested_execution_date;
	}
	public void setRequested_execution_date(String requested_execution_date) {
		this.requested_execution_date = requested_execution_date;
	}
	public String getCreditor_id() {
		return creditor_id;
	}
	public void setCreditor_id(String creditor_id) {
		this.creditor_id = creditor_id;
	}
	public String getDebtor_id() {
		return debtor_id;
	}
	public void setDebtor_id(String debtor_id) {
		this.debtor_id = debtor_id;
	}
	public String getRemittence_reference() {
		return remittence_reference;
	}
	public void setRemittence_reference(String remittence_reference) {
		this.remittence_reference = remittence_reference;
	}
	public String getRemittence_unstructured() {
		return remittence_unstructured;
	}
	public void setRemittence_unstructured(String remittence_unstructured) {
		this.remittence_unstructured = remittence_unstructured;
	}
	public String getPayment_context() {
		return payment_context;
	}
	public void setPayment_context(String payment_context) {
		this.payment_context = payment_context;
	}
	public String getInstruction_identification() {
		return instruction_identification;
	}
	public void setInstruction_identification(String instruction_identification) {
		this.instruction_identification = instruction_identification;
	}
	public String getEnd_to_end_identification() {
		return end_to_end_identification;
	}
	public void setEnd_to_end_identification(String end_to_end_identification) {
		this.end_to_end_identification = end_to_end_identification;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getExpected_execution_date() {
		return expected_execution_date;
	}
	public void setExpected_execution_date(String expected_execution_date) {
		this.expected_execution_date = expected_execution_date;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getFirst_payment_date() {
		return first_payment_date;
	}
	public void setFirst_payment_date(String first_payment_date) {
		this.first_payment_date = first_payment_date;
	}
	public String getFirst_payment_amount() {
		return first_payment_amount;
	}
	public void setFirst_payment_amount(String first_payment_amount) {
		this.first_payment_amount = first_payment_amount;
	}
	public String getFirst_payment_currency() {
		return first_payment_currency;
	}
	public void setFirst_payment_currency(String first_payment_currency) {
		this.first_payment_currency = first_payment_currency;
	}
	public String getFinal_payment_amount() {
		return final_payment_amount;
	}
	public void setFinal_payment_amount(String final_payment_amount) {
		this.final_payment_amount = final_payment_amount;
	}
	public String getFinal_payment_currency() {
		return final_payment_currency;
	}
	public void setFinal_payment_currency(String final_payment_currency) {
		this.final_payment_currency = final_payment_currency;
	}
	public String getFinal_payment_date() {
		return final_payment_date;
	}
	public void setFinal_payment_date(String final_payment_date) {
		this.final_payment_date = final_payment_date;
	}
	public String getInstruction_priority() {
		return instruction_priority;
	}
	public void setInstruction_priority(String instruction_priority) {
		this.instruction_priority = instruction_priority;
	}
	public String getCurrency_of_transfer() {
		return currency_of_transfer;
	}
	public void setCurrency_of_transfer(String currency_of_transfer) {
		this.currency_of_transfer = currency_of_transfer;
	}
	public String getExchange_rate() {
		return exchange_rate;
	}
	public void setExchange_rate(String exchange_rate) {
		this.exchange_rate = exchange_rate;
	}
	public String getExchange_rate_currency() {
		return exchange_rate_currency;
	}
	public void setExchange_rate_currency(String exchange_rate_currency) {
		this.exchange_rate_currency = exchange_rate_currency;
	}
	public String getExchange_rate_type() {
		return exchange_rate_type;
	}
	public void setExchange_rate_type(String exchange_rate_type) {
		this.exchange_rate_type = exchange_rate_type;
	}
	public String getExchange_rate_contract() {
		return exchange_rate_contract;
	}
	public void setExchange_rate_contract(String exchange_rate_contract) {
		this.exchange_rate_contract = exchange_rate_contract;
	}
	public String getExchange_rate_expiration_date() {
		return exchange_rate_expiration_date;
	}
	public void setExchange_rate_expiration_date(String exchange_rate_expiration_date) {
		this.exchange_rate_expiration_date = exchange_rate_expiration_date;
	}
	@Override
	public String toString() {
		return "Consents [consentId=" + consentId + ", creationDate=" + creationDate + ", status=" + status
				+ ", statusUpdationDate=" + statusUpdationDate + ", cut_off_date=" + cut_off_date + ", payment_amount="
				+ payment_amount + ", payment_currency=" + payment_currency + ", requested_execution_date="
				+ requested_execution_date + ", creditor_id=" + creditor_id + ", debtor_id=" + debtor_id
				+ ", remittence_reference=" + remittence_reference + ", remittence_unstructured="
				+ remittence_unstructured + ", payment_context=" + payment_context + ", instruction_identification="
				+ instruction_identification + ", end_to_end_identification=" + end_to_end_identification
				+ ", permission=" + permission + ", expected_execution_date=" + expected_execution_date + ", frequency="
				+ frequency + ", reference=" + reference + ", first_payment_date=" + first_payment_date
				+ ", first_payment_amount=" + first_payment_amount + ", first_payment_currency="
				+ first_payment_currency + ", final_payment_amount=" + final_payment_amount
				+ ", final_payment_currency=" + final_payment_currency + ", final_payment_date=" + final_payment_date
				+ ", instruction_priority=" + instruction_priority + ", currency_of_transfer=" + currency_of_transfer
				+ ", exchange_rate=" + exchange_rate + ", exchange_rate_currency=" + exchange_rate_currency
				+ ", exchange_rate_type=" + exchange_rate_type + ", exchange_rate_contract=" + exchange_rate_contract
				+ ", exchange_rate_expiration_date=" + exchange_rate_expiration_date + ", account=" + account + "]";
	}
	
	
	
	
	
}
