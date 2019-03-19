package com.cg.openbanking.payment.domesticPaymentAPI.request;

public class Risk {
	
	
	//@NotEmpty(message = "Payment context code is required")
	private String paymentContextCode;

	public String getPaymentContextCode() {
		return paymentContextCode;
	}

	public void setPaymentContextCode(String paymentContextCode) {
		this.paymentContextCode = paymentContextCode;
	}

	@Override
	public String toString() {
		return "Risk [paymentContextCode=" + paymentContextCode + "]";
	}

	
}
