

import java.util.Scanner;

public class Bounds {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int startingNum, upperBound, stepSize;
		int counter = 0;

		System.out.print("Please Enter a Starting Number: ");
		startingNum = input.nextInt();
		System.out.print("Please Enter a Upper Bound: ");
		upperBound = input.nextInt();
		System.out.print("Please Enter a Step Size: ");
		stepSize = input.nextInt();

		System.out.println();

		System.out.println("You've chosen\n\nStarting Number: " + startingNum + "\nUpper Bound: " + upperBound
				+ "\nStep Size: " + stepSize);

		System.out.println();

		for (int i = startingNum; i < upperBound; i += stepSize) {
			System.out.printf("%4d", i);
			counter++;

			if (counter % 10 == 0) {
				System.out.println();
			}
		}

		input.close();
	}

}