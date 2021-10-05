

import java.util.Scanner;

public class StringMethods {
	Scanner input = new Scanner(System.in);
	private String myStr = "";

	public void readString() {
		// Prompt the user and read in a String from a Scanner class from the keyboard
		// with the nextLine() method and store it in "myStr"
		System.out.print("Please enter in a String: ");
		myStr = input.nextLine();
	}

	public void setString(String s) {
		myStr = s;
	}

	public int countOccurrences(String s) {
		// use indexOf and return the number of occurrences of the string "s" in "myStr"
		int currentIndex = myStr.indexOf(s);
		int occurence = 0;

		for (int i = 0; i < myStr.length() - 1; i++) {
			if (myStr.indexOf(s, currentIndex) != -1) {
				currentIndex = myStr.indexOf(s, currentIndex) + 1;
				occurence++;
			} else {
				return occurence;
			}
		}
		return occurence;
	}

	public int countOccurrences(char c) {
		// use indexOf and return the number of occurrences of the character "c" in
		// "myStr"
		int currentIndex = myStr.indexOf(c);
		int occurence = 0;

		for (int i = 0; i < myStr.length() - 1; i++) {
			if (myStr.indexOf(c, currentIndex) != -1) {
				currentIndex = myStr.indexOf(c, currentIndex) + 1;
				occurence++;
			} else {
				return occurence;
			}
		}
		return occurence;
	}

	int countUpperCaseLetters() {
		// return the number of upper case letters in "myStr"
		int upperCase = 0;

		for (int i = 0; i < myStr.length() - 1; i++) {
			if (Character.isUpperCase(myStr.charAt(i))) {
				upperCase += 1;
			} else {
				continue;
			}
		}
		return upperCase;
	}

	int countLowerCaseLetters() {
		// return the number of lower case letters in "myStr"
		int lowerCase = 0;

		for (int i = 0; i < myStr.length() - 1; i++) {
			if (Character.isLowerCase(myStr.charAt(i))) {
				lowerCase += 1;
			} else {
				continue;
			}
		}
		return lowerCase;
	}

	public void printCounts(String s, char c) {
		System.out.println("***************************************");
		System.out.println("Analyzing: myStr = " + myStr);
		System.out.println("Number of Upper case letters = " + countUpperCaseLetters());
		System.out.println("Number of Lower case letters = " + countLowerCaseLetters());
		System.out.println("Number of " + s + " is " + countOccurrences(s));
		System.out.println("Number of " + c + " is " + countOccurrences(c));
	}

	public static void main(String[] args) {

		StringMethods msm = new StringMethods();
		msm.readString();
		msm.printCounts("big", 'a');

		msm.setString("Parked in a van down by the river bank .... The van evan vanished near a lot of other vans");
		msm.printCounts("van", 'a');

		StringMethods msm2 = new StringMethods();
		msm2.setString("the elephant in the room wouldn't budge");
		msm2.printCounts("the", 'i');

	}

}