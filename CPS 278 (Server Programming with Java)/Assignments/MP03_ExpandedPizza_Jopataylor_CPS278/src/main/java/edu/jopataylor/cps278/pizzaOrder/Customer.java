package edu.jopataylor.cps278.pizzaOrder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Customer {

	@NotBlank(message = "Required")
	private String name;
	@Valid
	@NotNull
	private Address theirAddress;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getTheirAddress() {
		return theirAddress;
	}

	public void setTheirAddress(Address theirAddress) {
		this.theirAddress = theirAddress;
	}

}


