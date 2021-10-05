

import java.util.Scanner;

public class TooMuchInMain {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int operand1, operand2, answer;
		char operator = 'q';
		boolean keepCalculating = true;

		while (keepCalculating) {
			boolean operator_is_good = false;
			do {
				System.out.print("Enter an Operator: + -* / q for quit: ");
				String strOperator = input.nextLine();
				strOperator = strOperator.trim();
				if (strOperator.length() == 0)
					continue;
				operator = strOperator.charAt(0);
				operator_is_good = false;
				switch (operator) {
				case 'q':
				case '+':
				case '-':
				case '*':
				case '/':
					operator_is_good = true;
					break;
				default:
					System.out.println("Your operator is bad ... try again:");
					break;
				}
			} while (!operator_is_good);

			if (operator == 'q') {
				keepCalculating = false;
				break;
			}

			int which = 1;
			System.out.println("Enter operand " + which);
			String stEntered;
			boolean operand_is_bad;
			do {
				operand_is_bad = false;
				stEntered = input.nextLine();
				stEntered = stEntered.trim();
				if (stEntered.length() == 0)
					operand_is_bad = true;
				for (int i = 0; i < stEntered.length(); i++) {
					char c = stEntered.charAt(i);
					if (c < '0' || c > '9') {
						operand_is_bad = true;
						System.out.println("Your last input was bad, try again");
					}
				}
			} while (operand_is_bad);

			operand1 = Integer.parseInt(stEntered);

			which = 2;
			System.out.println("Enter operand " + which);
			do {
				operand_is_bad = false;
				stEntered = input.nextLine();
				stEntered = stEntered.trim();
				if (stEntered.length() == 0)
					operand_is_bad = true;
				for (int i = 0; i < stEntered.length(); i++) {
					char c = stEntered.charAt(i);
					if (c < '0' || c > '9') {
						operand_is_bad = true;
						System.out.println("Your last input was bad, try again");
					}
				}
			} while (operand_is_bad);

			operand2 = Integer.parseInt(stEntered);

			switch (operator) {
			case '+':
				answer = operand1 + operand2;
				break;
			case '-':
				answer = operand1 - operand2;
				break;
			case '*':
				answer = operand1 * operand2;
				break;
			case '/':
				answer = operand1 / operand2;
				break;
			default:
				System.out.println("We shouldn't get here in doArithmentic!!!!");
				answer = -1;
				break;
			}

			System.out.println(operand1 + " " + operator + " " + operand2 + " = " + answer);
			System.out.println("=======================");
		}

		System.out.println("Finished Calculations");
		input.close();
	}

}