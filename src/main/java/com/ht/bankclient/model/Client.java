package com.ht.bankclient.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Client {
	final UUID id;
	Person person;
	List<Address> addresses;
	List<Account> accounts;
	
	public Client(@JsonProperty("id") UUID id, 
			@JsonProperty("person") Person person, 
			@JsonProperty("addresses")List<Address> addresses, 
			@JsonProperty("accounts")List<Account> accounts) {
		super();
		this.id = id;
		this.person = person;
		this.addresses = addresses;
		this.accounts = accounts;
	}

	public Person getPerson() {
		return person;
	}

	public UUID getId() {
		return id;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public void addAddress(Address address) {
		if (this.addresses==null)
			this.addresses = new ArrayList<Address>();
		this.addresses.add(address);
	}
	
	public void addAccount(Account account) {
		if (this.accounts==null)
			this.accounts = new ArrayList<Account>();
		this.accounts.add(account);
	}
}
