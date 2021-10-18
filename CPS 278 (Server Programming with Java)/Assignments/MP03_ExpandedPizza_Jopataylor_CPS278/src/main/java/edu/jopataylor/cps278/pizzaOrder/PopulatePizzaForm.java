package edu.jopataylor.cps278.pizzaOrder;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class PopulatePizzaForm {

	public Map<String, String> sizeOptions() {

		Map<String, String> sizeOptions = new LinkedHashMap<String, String>();

		sizeOptions.put("Small", "Small");
		sizeOptions.put("Medium", "Medium");
		sizeOptions.put("Large", "Large");

		return sizeOptions;
	}

	public Map<String, String> toppingOptions() {

		Map<String, String> toppingOptions = new LinkedHashMap<String, String>();

		toppingOptions.put("Pepperoni", "Pepperoni");
		toppingOptions.put("Sausage", "Sausage");
		toppingOptions.put("Green Pepper", "Green Pepper");
		toppingOptions.put("Onion", "Onion");
		toppingOptions.put("Red Pepper", "Red Pepper");

		return toppingOptions;
	}

	public Map<String, String> stateOptions() {

		Map<String, String> stateOptions = new LinkedHashMap<String, String>();

		stateOptions.put("Alaska", "Alaska");
		stateOptions.put("Colorado", "Colorado");
		stateOptions.put("Michigan", "Michigan");
		stateOptions.put("Oklahoma", "Oklahoma");
		stateOptions.put("Wyoming", "Wyoming");

		return stateOptions;
	}

}
