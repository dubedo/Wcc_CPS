package vid1.IntroCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {

		// Static Factory vs Traditional List Construction vs Conversion
		List<String> sFactoryList = List.of("MI", "OH", "FL");
		System.out.println(sFactoryList);

		List<String> list = new ArrayList<String>();
		list.add("MI");
		list.add("OH");
		list.add("Fl");
		System.out.println(list);

		String[] stringArray = { "MI", "OH", "FL" };
		// Both Conversion Methods Work.
		Arrays.asList(stringArray);
		List<String> arrayConversion = List.of(stringArray);
		System.out.println(arrayConversion);

		// By Index methods
		list.add(1, "WA");
		list.remove(0);
		list.set(1, "MA");
		System.out.println(list.get(1));

		// Lambda Functions
		list.replaceAll(u -> u.toLowerCase());
		System.out.println(list);

		// Method References
		list.replaceAll(String::toUpperCase);
		System.out.println(list);

		// Our Practice
		List<Integer> numbers = Arrays.asList(1, 2, 3);
		System.out.println(numbers);
		numbers.replaceAll(u -> u * 2);
		System.out.println(numbers);
		
	}

}
