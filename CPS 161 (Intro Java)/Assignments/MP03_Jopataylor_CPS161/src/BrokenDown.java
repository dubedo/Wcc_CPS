

import java.util.Scanner;

public class BrokenDown {
	Scanner input = new Scanner(System.in);

	boolean doCalculation() {
		int operand1, operand2, answer;
		char operator = getOperator();
		if (operator == 'q')
			return false;
		operand1 = getOperand(1);
		operand2 = getOperand(2);
		answer = doArithmetic(operator, operand1, operand2);
		format(operator, operand1, operand2, answer);
		return true;
	}

	char getOperator() {
		char operator = 'q';
		boolean operator_is_good = false;
		do {
			System.out.print("Enter an Operator: + - * / q for quit: ");
			String strOperator = input.nextLine();
			strOperator = strOperator.trim();
			if (strOperator.length() == 0)
				continue; // Need to try this again with no input
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
		return operator;
	}

	int getOperand(int which) {
		System.out.println("Enter operand " + which);
		String stEntered = "";
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
		return Integer.parseInt(stEntered);
	}

	int doArithmetic(char operator, int operand1, int operand2) {
		int answer = 0;
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
		return answer;
	}

	void format(char operator, int operand1, int operand2, int answer) {
		System.out.println(operand1 + " " + operator + " " + operand2 + " = " + answer);
	}

public static void main(String[] args) {
		BrokenDown firstInstance = new BrokenDown();
		
		while (firstInstance.doCalculation()) {
			System.out.println();
			System.out.println("Try Again?");
		}

		System.out.println("Finished Calculations");
		
	}
}