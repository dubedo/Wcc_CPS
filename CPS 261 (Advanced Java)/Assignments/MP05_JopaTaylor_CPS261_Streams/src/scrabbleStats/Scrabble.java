package scrabbleStats;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Scrabble {

	public static int wordValues(String theWord) {

		Map<Character, Integer> letterValues = new HashMap<Character, Integer>();
		letterValues.put('a', 1);
		letterValues.put('b', 3);
		letterValues.put('c', 3);
		letterValues.put('d', 2);
		letterValues.put('e', 1);
		letterValues.put('f', 4);
		letterValues.put('g', 2);
		letterValues.put('h', 4);
		letterValues.put('i', 1);
		letterValues.put('j', 8);
		letterValues.put('k', 5);
		letterValues.put('l', 1);
		letterValues.put('m', 3);
		letterValues.put('n', 1);
		letterValues.put('o', 1);
		letterValues.put('p', 3);
		letterValues.put('q', 10);
		letterValues.put('r', 1);
		letterValues.put('s', 1);
		letterValues.put('t', 1);
		letterValues.put('u', 1);
		letterValues.put('v', 8);
		letterValues.put('w', 4);
		letterValues.put('x', 8);
		letterValues.put('y', 4);
		letterValues.put('z', 10);

		int valueOfWord = 0;
		theWord = theWord.toLowerCase();

		for (int i = 0; i < theWord.length(); i++) {
			valueOfWord = letterValues.get(theWord.charAt(i)) + valueOfWord;
		}

		return valueOfWord;
	}

	public static void main(String[] args) {

		String[] wordsToTest = { "Java", "program", "list", "string", "unix", "hours", "syntax", "error" };

		// The Three Largest Words
		System.out.println("The Three Largest Srabble Words in Our List");
		System.out.println();
		Stream.of(wordsToTest).sorted((word1, word2) -> wordValues(word2) - wordValues(word1)).limit(3)
				.forEach(e -> System.out.println(e + " : Value is " + wordValues(e)));
		System.out.println();

		// The Average Score
		System.out.println("The Average Scrabble Score Per Word in Our List");
		System.out.println();
		System.out.println(Stream.of(wordsToTest).mapToInt(e -> wordValues(e)).average().getAsDouble());
		System.out.println();

		// The Words Above or Below that Average
		double wordAverage = Stream.of(wordsToTest).mapToInt(e -> wordValues(e)).average().getAsDouble();
		System.out.println("The Words in Our List Above the average of " + wordAverage);
		System.out.println();
		Stream.of(wordsToTest).collect(Collectors.groupingBy(e -> wordValues(e) > wordAverage))
				.forEach((k, v) -> System.out.println(k + ": " + v));
		;

	}

}
