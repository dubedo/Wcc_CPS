

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int cents, dollars;
		int dollarsRecieved, centsRecieved, totalRecieved;
		int totalDue, totalChange;

		System.out.print("Please Enter Items Dollar Amount: ");
		dollars = input.nextInt() * 100;
		System.out.print("Please Enter Items Cents Amount: ");
		cents = input.nextInt();
		totalDue = dollars + cents;
		System.out.println("Your total is: " + dollars / 100 + " dollars and " + cents + " cents.");

		System.out.println();

		System.out.print("Please Enter Value Paid for in Dollar(s): ");
		dollarsRecieved = input.nextInt() * 100;
		System.out.print("Please Enter Value Paid for in Cent(s): ");
		centsRecieved = input.nextInt();
		totalRecieved = dollarsRecieved + centsRecieved;
		System.out.println("Total Recieved is: " + dollarsRecieved / 100 + " dollars and " + centsRecieved + " cents.");

		System.out.println();
		totalChange = totalRecieved - totalDue;
		System.out.println(
				"Your Total Change is: " + (totalChange / 100) + " dollars and " + (totalChange % 100) + " cents.");

		System.out.println();
		System.out.println("Your Change Back will be:\n" + (totalChange / 100) + " Dollar(s)");
		totalChange = totalChange % 100;
		System.out.println(totalChange / 25 + " Quarter(s)");
		totalChange = totalChange % 25;
		System.out.println(totalChange / 10 + " Dime(s)");
		totalChange = totalChange % 10;
		System.out.println(totalChange / 5 + " Nickel(s)");
		totalChange = totalChange % 5;
		System.out.println(totalChange + " Pennie(s)");

		input.close();

	}

}