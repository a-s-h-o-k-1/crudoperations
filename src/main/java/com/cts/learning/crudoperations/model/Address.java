package com.cts.learning.crudoperations.model;

public class Address {
	private Long id;

	private String street;

	private String city;

	private String zipcode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Address(Long id, String street, String city, String zipcode) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city + ", zipcode=" + zipcode + "]";
	}
	

}