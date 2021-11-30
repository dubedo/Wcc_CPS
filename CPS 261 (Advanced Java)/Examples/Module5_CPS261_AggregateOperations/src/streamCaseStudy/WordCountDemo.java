package streamCaseStudy;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WordCountDemo {

	public static void main(String[] args) {

		String str = "one two one three one four four five six";

		// Word Count
		Stream.of(str.split(" ")).collect(Collectors.groupingBy(e -> e, Collectors.counting()))
				.forEach((k, v) -> System.out.println(k + ":" + v));

		System.out.println();

		// Character Count
		Stream.of(str.split("")).collect(Collectors.groupingBy(e -> e, Collectors.counting()))
				.forEach((k, v) -> System.out.println(k + ":" + v));

		System.out.println();

		// Filter the WhiteSpace Out
		Stream.of(str.split("")).filter(e -> !e.equals(" "))
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()))
				.forEach((k, v) -> System.out.println(k + ":" + v));

		System.out.println();

		int[][] doubleIntArray = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 6 }, { 5 } };

		Stream.of(doubleIntArray).flatMapToInt(e -> IntStream.of(e)).forEach(System.out::println);

	}

}
