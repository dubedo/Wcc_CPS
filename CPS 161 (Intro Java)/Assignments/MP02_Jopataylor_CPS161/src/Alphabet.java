

public class Alphabet {

	public static boolean isVowel(char currentLetter) {
		switch (currentLetter) {
		case 'a':
			return true;
		case 'e':
			return true;
		case 'i':
			return true;
		case 'o':
			return true;
		case 'u':
			return true;
		default:
			return false;
		}
	}

	public static void main(String[] args) {

		char startingLetter = 'a';

		while (startingLetter <= 'z') {
			System.out.print(startingLetter);

			if (isVowel(startingLetter)) {
				System.out.println(": is a vowel.");
				startingLetter++;
			} else {
				System.out.println(": is a consonant.");
				startingLetter++;
			}
		}
	}
}