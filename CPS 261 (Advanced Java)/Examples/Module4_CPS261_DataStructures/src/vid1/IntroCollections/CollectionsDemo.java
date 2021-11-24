package vid1.IntroCollections;

import java.util.Collection;
import java.util.HashSet;

public class CollectionsDemo {

	public static void main(String[] args) {

		Collection<String> birds = new HashSet<String>();

		// the add method
		System.out.println(birds.add("Hawk"));
		System.out.println(birds.add("Hawk"));
		birds.add("Owl");
		System.out.println(birds);

		// the remove method
		birds.remove("Hawk");
		System.out.println(birds);

		// the contains method. utilzes classes .equals() method
		System.out.println(birds.contains("Owl") + ". Owl is in the D.Sequence");
		System.out.println(birds.contains("Fish") + ". Fish is not in the D.Sequence");

		System.out.println(birds);

		// a lambda removal. requires a predicate
		birds.removeIf(s -> s.startsWith("O"));
		System.out.println(birds);
		birds.add("");
		birds.add("Falcon");
		System.out.println(birds);
		birds.removeIf(s -> s.isEmpty());
		System.out.println(birds);

		// method references.
		birds.removeIf(String::isEmpty);
		birds.forEach(s -> System.out.println(s));
		birds.forEach(System.out::println);

		for (String bird : birds) {
			birds.remove(bird);
		}
		birds.clear();

		System.out.println(birds);
		System.out.println(birds.isEmpty());
		System.out.println(birds.size());

		System.out.println(birds);

	}

}
