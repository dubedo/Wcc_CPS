package edu.jopataylor.cps278.pizzaOrder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Order {

	@Valid
	@NotNull
	private Customer theCustomer;

	private Pizza thePizza;

	public Customer getTheCustomer() {
		return theCustomer;
	}

	public void setTheCustomer(Customer theCustomer) {
		this.theCustomer = theCustomer;
	}

	public Pizza getThePizza() {
		return thePizza;
	}

	public void setThePizza(Pizza thePizza) {
		this.thePizza = thePizza;
	}

}
