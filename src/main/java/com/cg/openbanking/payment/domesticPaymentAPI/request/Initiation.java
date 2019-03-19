package com.cg.openbanking.payment.domesticPaymentAPI.request;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Initiation {
	
	@NotEmpty (message = "Instruction Identification is required")
	private String instructionIdentification;
	
	@NotEmpty (message = "End to End Identification is required")
	private String endToEndIdentification;
	
	@NotNull
	@Valid
	private InstructedAmount instructedAmount;
	
	@NotNull
	@Valid
	private DebtorAccount debtorAccount;
	
	@NotNull
	@Valid
	private CreditorAccount creditorAccount;
	
	@NotNull
	@Valid
	private RemittanceInformation remittanceInformation;
	
	public String getInstructionIdentification() {
		return instructionIdentification;
	}
	public void setInstructionIdentification(String instructionIdentification) {
		this.instructionIdentification = instructionIdentification;
	}
	public String getEndToEndIdentification() {
		return endToEndIdentification;
	}
	public void setEndToEndIdentification(String endToEndIdentification) {
		this.endToEndIdentification = endToEndIdentification;
	}
	public InstructedAmount getInstructedAmount() {
		return instructedAmount;
	}
	public void setInstructedAmount(InstructedAmount instructedAmount) {
		this.instructedAmount = instructedAmount;
	}
	public DebtorAccount getDebtorAccount() {
		return debtorAccount;
	}
	public void setDebtorAccount(DebtorAccount debtorAccount) {
		this.debtorAccount = debtorAccount;
	}
	public CreditorAccount getCreditorAccount() {
		return creditorAccount;
	}
	public void setCreditorAccount(CreditorAccount creditorAccount) {
		this.creditorAccount = creditorAccount;
	}
	public RemittanceInformation getRemittanceInformation() {
		return remittanceInformation;
	}
	public void setRemittanceInformation(RemittanceInformation remittanceInformation) {
		this.remittanceInformation = remittanceInformation;
	}
	@Override
	public String toString() {
		return "Initiation [instructionIdentification=" + instructionIdentification + ", endToEndIdentification="
				+ endToEndIdentification + ", instructedAmount=" + instructedAmount + ", debtorAccount=" + debtorAccount
				+ ", creditorAccount=" + creditorAccount + ", remittanceInformation=" + remittanceInformation + "]";
	}
	
	
	
}
