package vid1.IntroCollections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings("unused")
public class SetDemo {

	public static void main(String[] args) {

		// Hash Vs Tree set Behavior in Storage/Order/Sorted Values

		Set<Integer> set = new HashSet<Integer>();
		// Set<Integer> set = new TreeSet<Integer>();

		set.add(66);
		set.add(10);
		set.add(8);

		System.out.println(set);

	}

}
