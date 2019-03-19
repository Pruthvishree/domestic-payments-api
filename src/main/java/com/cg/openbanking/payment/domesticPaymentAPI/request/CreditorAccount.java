package com.cg.openbanking.payment.domesticPaymentAPI.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CreditorAccount {
	
	@NotEmpty(message = "Creditor schema name is required")
	private String schemeName;
	
	@NotEmpty(message = "Creditor identification is required")
	@Size(min=12, max=15, message =" Identification size must be between 12 and 15 ")
	private String identification;
	
	@NotEmpty(message = "Creditor name is required")
	private String name;
	
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CreditorAccount [schemeName=" + schemeName + ", identification=" + identification + ", name=" + name
				+ "]";
	}
	
	
	
	
	
}
