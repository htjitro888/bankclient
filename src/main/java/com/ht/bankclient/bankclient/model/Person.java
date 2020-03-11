package com.ht.bankclient.bankclient.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	String firstname;
	String lastname;
	String gender;
	Date birthdate;
	
	public Person(@JsonProperty("firstname") String firstname, 
			@JsonProperty("lastname") String lastname, 
			@JsonProperty("gender") String gender, 
			@JsonProperty("birthdate") Date birthdate) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.birthdate = birthdate;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	
}
