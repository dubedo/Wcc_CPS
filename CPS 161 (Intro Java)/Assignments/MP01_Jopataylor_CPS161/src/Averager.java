

import java.util.Scanner;

public class Averager {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int value1, value2, value3;
		double average;

		System.out.print("Please enter the First Value: ");
		value1 = input.nextInt();
		System.out.print("Please enter the Second Value: ");
		value2 = input.nextInt();
		System.out.print("Please enter the Third Value: ");
		value3 = input.nextInt();

		System.out.println();

		System.out.println("To Confirm, the values you entered were: " + value1 + ", " + value2 + ", " + value3 + ".");
		average = (value1 + value2 + value3) / 3.;
		System.out.printf("The average of these three values is: %.2f ", average);
		System.out.println();

		input.close();

	}

}
