package singleDigits;

import java.util.Random;
import java.util.stream.Collectors;

public class SingleDigitCount {

	public static void main(String[] args) {

		Random randomNumber = new Random();

		randomNumber.ints(0, 10).limit(100).mapToObj(Integer::valueOf)
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()))
				.forEach((k, v) -> System.out.println(k + ":" + v));

	}

}
