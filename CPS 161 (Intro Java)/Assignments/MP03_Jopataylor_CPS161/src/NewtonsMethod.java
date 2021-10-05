

import java.util.Scanner;

public class NewtonsMethod {

	public static double newtonianGuess(double initialNumber, double numberGuessed) {
		double betterGuess, numberInput, initialGuess, accuracy;

		numberInput = initialNumber;
		initialGuess = numberGuessed;

		do {
			betterGuess = ((numberInput / initialGuess) + initialGuess) / 2;
			accuracy = Math.abs(betterGuess - initialGuess);
			initialGuess = betterGuess;

		} while (accuracy > .000001);
		return betterGuess;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double numberInput, initialGuess, finalGuess;

		System.out.print("Please enter the Number you wish Newton to find the Root For: ");

		numberInput = input.nextDouble();
		initialGuess = numberInput / 2;
		finalGuess = newtonianGuess(numberInput, initialGuess);

		System.out.println("Newtons Final Guess is: " + finalGuess);
		System.out.println("Compared to the Actual Root which is: " + Math.sqrt(numberInput));

		input.close();
	}
}
