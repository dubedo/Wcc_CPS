

import java.util.Scanner;

public class Jar {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int pennies, nickels, dimes, quarters, valueOfChange, dollars, cents;

		System.out.print("How many pennies do you have in the Jar? ");
		pennies = input.nextInt();
		System.out.print("How many nickels do you have in the Jar? ");
		nickels = input.nextInt();
		System.out.print("How many dimes do you have in the Jar? ");
		dimes = input.nextInt();
		System.out.print("How many quarters do you have in the Jar? ");
		quarters = input.nextInt();

		valueOfChange = (quarters * 25) + (dimes * 10) + (nickels * 5) + (pennies);
		dollars = valueOfChange / 100;
		cents = valueOfChange % 100;

		System.out.println();
		System.out.println("Total Change is: " + valueOfChange + " cents. ");
		System.out.print("Also known as: " + dollars + " dollars and " + cents + " cents.");

		input.close();

	}

}