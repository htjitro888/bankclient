package com.ht.bankclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bank {
	String name;
	String routingNumber;
	Address address;
	
	public Bank(@JsonProperty("name") String name, 
			@JsonProperty("routingNumber") String routingNumber, 
			@JsonProperty("address") Address address) {
		super();
		this.name = name;
		this.routingNumber = routingNumber;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
