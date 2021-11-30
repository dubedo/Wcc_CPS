package numberStreamDemo;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamDemo {

	public static void main(String[] args) {

		int[] values = { 3, 4, 1, 5, 20, 1, 3, 3, 4, 6 };

		// The Idea of Distinct and Filter and Average Return.
		System.out.println("The Average of Distinct Even Numbers > 3: "
				+ IntStream.of(values).distinct().filter(e -> ((e > 3) && (e % 2 == 0))).average().getAsDouble());

		// The Idea of Limit and Sum Returning an Int.
		System.out.println("The Sum of First Four Numbers: " + IntStream.of(values).limit(4).sum());

		IntSummaryStatistics stats = IntStream.of(values).summaryStatistics();
		System.out.println("Count: " + stats.getCount());
		System.out.println("Sum: " + stats.getSum());
		System.out.println(("Min: " + stats.getMin()));
		System.out.println("Max: " + stats.getMax());
		System.out.println("Avg; " + stats.getAverage());

		String[] names = { "John", "Peter", "Susan", "Kim", "Jen", "George", "Alan", "Stacy", "Michelle", "john" };

		System.out
				.println("Total Character Count for All Names is: " + Stream.of(names).mapToInt(e -> e.length()).sum());

		System.out.println("The Number of Digits in the Array Values is "
				+ Stream.of(values).map(e -> e + "").mapToInt(e -> e.length()).sum());

	}

}
