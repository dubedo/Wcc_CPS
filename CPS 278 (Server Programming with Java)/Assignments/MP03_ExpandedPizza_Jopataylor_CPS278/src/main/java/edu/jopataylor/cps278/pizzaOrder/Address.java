package edu.jopataylor.cps278.pizzaOrder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Address {

	@NotBlank(message = "Please Enter a Valid Street Name")
	private String street;
	@NotBlank(message = "Please Enter a Valid City Name")
	private String city;
	private String state;
	@NotBlank(message = "Please Enter a Valid Zip Code")
	@Pattern(regexp = "^[0-9]{5}", message = "5 Numbers Please")
	private String zipCode;

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
	}

}