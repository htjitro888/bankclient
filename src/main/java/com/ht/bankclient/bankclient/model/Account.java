package com.ht.bankclient.bankclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {
	Bank bank;
	Integer accountNumber;
	String type;
	Long balance;
	
	public Account(@JsonProperty("bank") Bank bank, 
			@JsonProperty("accountNumber") Integer accountNumber, 
			@JsonProperty("type") String type, 
			@JsonProperty("balance") Long balance) {
		super();
		this.bank = bank;
		this.accountNumber = accountNumber;
		this.type = type;
		this.balance = balance;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}
	
	
}
