package edu.wccnet.jopataylor.spring_hibernate.entity;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class PizzaService {

	public Map<String, String> populateSize() {
		Map<String, String> sizeList = new LinkedHashMap<String, String>();

		sizeList.put("Small", "Small");
		sizeList.put("Medium", "Medium");
		sizeList.put("Large", "Large");
		sizeList.put("Party", "Party");

		return sizeList;
	}

	public Map<String, String> populateTopping() {
		Map<String, String> toppingList = new LinkedHashMap<String, String>();

		toppingList.put("Sausage", "Sausage");
		toppingList.put("Green Pepper", "Green Pepper");
		toppingList.put("Onion", "Onion");
		toppingList.put("Pepperoni", "Pepperoni");

		return toppingList;
	}

	public Map<String, String> populateState() {
		Map<String, String> stateList = new LinkedHashMap<String, String>();

		stateList.put("MI", "MI");
		stateList.put("WI", "WI");
		stateList.put("IN", "IN");
		stateList.put("GA", "GA");

		return stateList;
	}

}
