package generic;

import java.util.ArrayList;

public class GenericDemo {

	public static void main(String[] args) {

		ArrayList<Integer> theList = new ArrayList<>();

		theList.add(1);
		theList.add(2);

		// Not the Right Type as Defined in the declaration
		// theList.add("Hi");

		for (Integer i : theList) {
			System.out.println(i);
		}
	}

}
