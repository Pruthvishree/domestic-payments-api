package com.cg.openbanking.payment.domesticPaymentAPI.request;

import javax.validation.constraints.NotEmpty;

public class RemittanceInformation {
	@NotEmpty (message ="Reference is required")
	private String reference;
	
	@NotEmpty (message ="Unstructured is required")
	private String unstructured;
	
	
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getUnstructured() {
		return unstructured;
	}
	public void setUnstructured(String unstructured) {
		this.unstructured = unstructured;
	}
	@Override
	public String toString() {
		return "RemittanceInformation [reference=" + reference + ", unstructured=" + unstructured + "]";
	}
	
	
	
}
