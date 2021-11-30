package sortDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		String[] stringArray = { "a5", "A8", "B7", "B3" };

		List<String> stringList = Arrays.asList("a5", "A8", "B7", "B3"); // NOT REALLY A LIST. WRAPPED.

		// List<String> stringList = new ArrayList<>(Arrays.asList("a5", "A8", "B7",
		// "B3")); // REALLY AN ARRAYLIST.

		List<String> newList = new ArrayList<>();

		// The Old Way

		stringList.forEach(e -> {
			if (e.toUpperCase().startsWith("A")) {
				newList.add(e);
			}
		});

		newList.sort((s1, s2) -> {
			return s1.compareTo(s2);
		});

		newList.forEach(System.out::println);

		System.out.println();
		System.out.println("******* A Seperation");
		System.out.println();

		// The Stream Way

		stringList.stream().map(s -> s.toUpperCase()).filter(s -> s.startsWith("A")).sorted()
				.forEach(System.out::println);

		System.out.println();

		System.out
				.println(stringList.stream().map(s -> s.toUpperCase()).filter(s -> s.startsWith("A")).sorted().count());

	}

}
