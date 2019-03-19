package com.cg.openbanking.payment.domesticPaymentAPI.request;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class PaymentRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	@Valid
	private Data data;
	
	
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "PaymentRequest [data=" + data +  "]";
	}

	

	

}
