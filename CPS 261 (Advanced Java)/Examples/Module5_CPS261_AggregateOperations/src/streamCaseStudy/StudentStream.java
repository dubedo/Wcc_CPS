package streamCaseStudy;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentStream {

	public static void main(String[] args) {

		Student[] studentArray = { new Student("John", "CS", 87.5), new Student("Jane", "BIO", 92.7),
				new Student("Peter", "CS", 73) };

		Stream.of(studentArray)
				.collect(Collectors.groupingBy(e -> e.getMajor(), Collectors.averagingDouble(e -> e.getScore())))
				.forEach((k, v) -> System.out.println(k + ":" + v));

		System.out.println();

		Stream.of(studentArray).collect(Collectors.groupingBy(e -> e.getMajor()))
				.forEach((k, v) -> System.out.println(k + ":" + v));

	}

}
