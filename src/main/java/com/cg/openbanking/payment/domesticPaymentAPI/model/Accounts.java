package com.cg.openbanking.payment.domesticPaymentAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Accounts {
	
	@Column(name="currency")
	private String currency;
	
	@Id

	@Column(name="account_id")
	private String accountId;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="account_sub_type")
	private String accountSubType;
	
	@Column(name="description")
	private String description;
	
	@Column(name="nickname")
	private String nickname;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountSubType() {
		return accountSubType;
	}

	public void setAccountSubType(String accountSubType) {
		this.accountSubType = accountSubType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Accounts [currency=" + currency + ", accountId=" + accountId + ", accountType=" + accountType
				+ ", accountSubType=" + accountSubType + ", description=" + description + ", nickname=" + nickname
				+ "]";
	}
	
	
}
