package pizzaOrdering;

import java.util.Arrays;
import java.util.Scanner;

class Customer {

	Scanner kBoard = new Scanner(System.in);

	private String name;
	private Address address;

	public Customer(String name, Address address) {

		this.name = name;
		this.address = address;

	}

	public Customer() {

	}

	public void setCustInfo() {

		String street, city, state, zipCode;

		System.out.print("Name: ");
		this.name = kBoard.nextLine();

		System.out.print("Street: ");
		street = kBoard.nextLine();
		System.out.print("City: ");
		city = kBoard.nextLine();
		System.out.print("State: ");
		state = kBoard.nextLine();
		System.out.print("Zip Code: ");
		zipCode = kBoard.nextLine();

		address = new Address(street, city, state, zipCode);

	}

	@Override
	public String toString() {
		return "\nName = " + name + "\nAddress = " + address;
	}

}

class Address {

	private String street, city, state, zipCode;

	public Address(String street, String city, String state, String zipCode) {

		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;

	}

	@Override
	public String toString() {
		return street + ", " + city + ", " + state + ", " + zipCode;
	}

}

class Pizza {

	private String size;
	private int toppingNum;
	private String[] toppings;

	public Pizza(String size, int toppingNum, String[] toppings) {

		this.size = size;
		this.toppingNum = toppingNum;
		this.toppings = toppings;

	}

	@Override
	public String toString() {
		return "Pizza Size = " + size + ", " + toppingNum + " toppings: " + Arrays.toString(toppings);
	}

}

class Order {

	Scanner kBoard = new Scanner(System.in);

	private int pizzaNum;
	private Pizza[] theirPizzas;

	public Order() {

	}

	public void setOrderNum() {

		System.out.println("How Many Pizzas Would You Like?");
		pizzaNum = kBoard.nextInt();
		kBoard.nextLine();

	}

	void toppingList() {
		System.out.println("Choices Include:\nSausage\nGreen Pepper\nOnion\nPepperoni");
	}

	Pizza[] pizzaInfo(int pizzaNum) {

		Pizza[] thePizzas = new Pizza[pizzaNum];
		String size;
		String[] toppings;
		int howManyToppings;

		for (int i = 0; i < pizzaNum; i++) {

			System.out.println("What Size Should Pizza " + (i + 1) + " Be?");
			size = kBoard.nextLine();

			System.out.println("How Many Toppings Should Pizza " + (i + 1) + " Have?");
			howManyToppings = kBoard.nextInt();
			kBoard.nextLine();

			toppings = new String[howManyToppings];
			toppingList();

			for (int j = 0; j < howManyToppings; j++) {

				System.out.print("Topping " + (j + 1) + ": ");
				toppings[j] = kBoard.nextLine();

			}

			thePizzas[i] = new Pizza(size, howManyToppings, toppings);

		}

		theirPizzas = thePizzas;
		return thePizzas;

	}

	public int getOrderNum() {

		return pizzaNum;

	}

	@Override
	public String toString() {

		String orderDisplay = "";

		for (Pizza pizza : theirPizzas) {
			orderDisplay = orderDisplay + pizza.toString() + "\n";
		}
		return orderDisplay;
	}

}

public class OrderPizza {

	public static void main(String[] args) {

		System.out.println("Please Enter Your Information\n");

		Customer theCustomer = new Customer();
		theCustomer.setCustInfo();

		Order theirOrder = new Order();
		theirOrder.setOrderNum();
		theirOrder.pizzaInfo(theirOrder.getOrderNum());

		System.out.println();

		System.out.println("Order Details:\n");
		System.out.println("Customer Information: " + theCustomer.toString() + "\n");
		System.out.println("Ordered " + theirOrder.getOrderNum() + " Pizzas.");
		System.out.println(theirOrder.toString());

	}

}
