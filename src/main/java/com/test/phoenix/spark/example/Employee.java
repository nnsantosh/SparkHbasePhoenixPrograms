package com.test.phoenix.spark.example;

import java.sql.Date;

public class Employee implements java.io.Serializable{
	
	
	private static final long serialVersionUID = -2003661319715120901L;
	
	private Long id;
	private String firstName;
	private String lastName;
	private String state;
	private String city;
	private String zipCode;
	private String country;
	private Date created_date;
	private Date last_updated;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(Date last_updated) {
		this.last_updated = last_updated;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", state=" + state
				+ ", city=" + city + ", zipCode=" + zipCode + ", country=" + country + ", created_date=" + created_date
				+ ", last_updated=" + last_updated + "]";
	}
	
	
	

}
