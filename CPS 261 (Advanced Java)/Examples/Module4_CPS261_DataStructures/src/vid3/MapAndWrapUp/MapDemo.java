package vid3.MapAndWrapUp;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {

		Map<String, String> courseMap = new HashMap<>();

		// How to Add things to the Map
		courseMap.put("CPS161", "Intro Java");
		courseMap.put("CPS261", "Advanced Java");
		courseMap.put("CPS251", "Android Programming");
		// Put returns a string of what is currently LINKED with that KEY.
		// NUll if there's nothing.
		System.out.println(courseMap.put("CPS161", "OverWritten Java"));
		System.out.println(courseMap);

		// How to Retrieve From the Map
		System.out.println(courseMap.get("CPS161"));

		// Key Validation
		System.out.println(courseMap.containsKey("CPS261"));

		// return a Set of all Keys
		for (String key : courseMap.keySet()) {
			System.out.println(key);
		}

		// return a Set of all Values. One By Accessing the all Keys.
		for (String value : courseMap.values()) {
			System.out.println(value);
		}
		for (String key : courseMap.keySet()) {
			System.out.println(courseMap.get(key));
		}

		// remove a key-value pair
		courseMap.remove("CPS251");

		// replace
		courseMap.replace("CPS161", "Old Overwritten Java");
		System.out.println(courseMap.get("CPS161"));

		// forEach
		courseMap.forEach((k, v) -> System.out.println(k + " " + v));

		// Appending
		courseMap.replaceAll((k, v) -> v + " is a great class.");
		courseMap.forEach((k, v) -> System.out.println(k + " " + v));
	}

}
