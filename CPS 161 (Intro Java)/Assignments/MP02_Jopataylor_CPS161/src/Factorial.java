

import java.util.Scanner;

public class Factorial {

	static Scanner input = new Scanner(System.in);
	static boolean flag;
	static int numbEntered;

	public static boolean isInputCorrect() {
		do {
			if (input.hasNextInt()) {
				flag = true;
			} else {
				String fakeNews = input.nextLine();
				System.out.println("\"" + fakeNews + "\"" + " is not a valid Integer. Please Try again.");
				flag = false;
			}
		} while (!flag);
		return flag;
	}

	public static int factorial(int numberPassed) {
		if (numberPassed == 0) {
			return 1;
		} else {
			int recursive = factorial(numberPassed - 1);
			int result = numberPassed * recursive;
			return result;
		}
	}

	public static boolean toContinue(String toContinue) {
		toContinue = input.nextLine().toUpperCase();
		char yOrNo = toContinue.charAt(0);

		if (yOrNo == 'Y') {
			System.out.println();
			return true;
		} else {
			System.out.println();
			System.out.println("Thank you, Bye.");
			return false;
		}
	}

	public static void main(String[] args) {

		do {
			System.out.print("Please enter a number whose Factorial value you wish to See: ");

			isInputCorrect();
			numbEntered = input.nextInt();

			System.out.print("The Factorial Value of " + numbEntered + " is: " + factorial(numbEntered));
			System.out.print("\nDo you with to Continue? (Y/N): ");
		} while (toContinue(input.nextLine()));

	}

}
