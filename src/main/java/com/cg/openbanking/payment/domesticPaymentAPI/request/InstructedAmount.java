package com.cg.openbanking.payment.domesticPaymentAPI.request;

import javax.validation.constraints.NotEmpty;

public class InstructedAmount {
	
	@NotEmpty(message = "Amount is required")
	private String amount;
	
	@NotEmpty(message = "Currency is required")
	private String currency;
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@Override
	public String toString() {
		return "InstructedAmount [amount=" + amount + ", currency=" + currency + "]";
	}
	
	
	
	
}
