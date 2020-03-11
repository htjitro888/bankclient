package com.ht.bankclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
	String street1;
	String street2;
	String city;
	String state;
	String zipcode;
	String country;
	String type;
	
	public Address(@JsonProperty("street1") String street1, 
			@JsonProperty("street2") String street2, 
			@JsonProperty("city") String city, 
			@JsonProperty("state") String state, 
			@JsonProperty("zipcode") String zipcode, 
			@JsonProperty("country") String country, 
			@JsonProperty("type") String type) {
		super();
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
		this.type = (type!=null && type.trim().length()>0) ? type : "Other";
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
