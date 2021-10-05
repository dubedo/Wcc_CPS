

import java.util.Scanner;

public class Temperature {

	static Scanner input = new Scanner(System.in);
	static int counter = 0;
	static double centigrade = 0, farenheit = 0;
	static double cTotal, fTotal;
	static boolean flag;

	public static boolean isInputCorrect() {
		do {
			if (input.hasNextDouble()) {
				flag = true;
			} else {
				String fakeNews = input.next();
				System.out.println(fakeNews + " is not a valid Temperature. Please Try again.");
				flag = false;
			}
		} while (!flag);
		return flag;
	}

	public static void main(String[] args) {

		do {
			System.out.print("Please enter a decimal temperature in Centigrade or a Value of -100.0 or lower to quit: ");

			isInputCorrect();
			centigrade = input.nextDouble();
			if (centigrade <= -100) {
				break;
			}

			counter++;
			farenheit = (9.0 / 5.0) * centigrade + 32.0;
			cTotal = cTotal + centigrade;
			fTotal = fTotal + farenheit;

			System.out.println(centigrade + "° Celsius is " + farenheit + "° Farenheit");
			System.out.println();

		} while (centigrade > -100);

		System.out.println("Your Average Temperatures across " + counter + " days were " + (cTotal / counter)
				+ "° Celsius and " + (fTotal / counter) + "° Farenheit.");

		input.close();

	}

}
