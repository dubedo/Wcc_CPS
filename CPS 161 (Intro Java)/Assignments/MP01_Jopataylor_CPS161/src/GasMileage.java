

import java.util.Scanner;

public class GasMileage {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		double gallonsConsumed, mpg;
		int distanceTraveled;

		System.out.println("Please enter a distance traveled: ");
		distanceTraveled = input.nextInt();

		System.out.println("Please enter amount of gallons of gas consumed: ");
		gallonsConsumed = input.nextDouble();

		mpg = distanceTraveled / gallonsConsumed;

		System.out.printf("Your car gets %.2f ", mpg);
		System.out.println("Miles Per Gallon.");
		input.close();

	}

}
