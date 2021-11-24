package spellChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SpellCheck {

	private HashSet<String> dictionary = new HashSet<String>();
	private TreeSet<String> incorrectWords = new TreeSet<String>();

	public SpellCheck() throws FileNotFoundException {

		Scanner fileInput = new Scanner(new File("dictionary.txt"));

		while (fileInput.hasNextLine()) {
			dictionary.add(fileInput.nextLine());
		}

		fileInput.close();
	}

	@SuppressWarnings("resource")
	public void checkSpelling(String fileName) throws FileNotFoundException {

		System.out.println("***** Spell Checking " + fileName + " *****");

		incorrectWords.clear();

		Scanner fileInput = new Scanner(new File(fileName));
		Scanner kbInput = new Scanner(System.in);

		int lineNumber = 1;
		boolean linePrint;

		while (fileInput.hasNextLine()) {

			String[] words = fileInput.nextLine().split(" +|\\p{Punct}");

			linePrint = true;

			for (String word : words) {

				if (word.isEmpty()) {
					continue;
				}

				word = word.toLowerCase();

				if (!Character.isLetter(word.charAt(0))) {
					continue;
				}

				if (dictionary.contains(word) || incorrectWords.contains(word)) {
					continue;
				}

				if (word.endsWith("s")) {

					word = word.substring(0, word.length() - 1);

					if (dictionary.contains(word) || incorrectWords.contains(word)) {
						continue;
					}

				}

				if (linePrint) {

					System.out.println("Line Number: " + lineNumber);
					linePrint = false;
				}

				System.out.println(word + " add To Dictionary? y or n");

				if (kbInput.nextLine().charAt(0) == 'y') {

					dictionary.add(word);
				} else {

					incorrectWords.add(word);
				}

			}

			lineNumber += 1;
		}

		fileInput.close();
	}

	public void dumpIncorrectWords() {

		System.out.println("***** Incorrect Words *****");

		for (String word : incorrectWords) {

			System.out.println(word);
		}
	}

	public static void main(String[] args) {

		try {

			SpellCheck spellCheck = new SpellCheck();

			for (int i = 0; i < args.length; i++) {

				spellCheck.checkSpelling(args[i]);
				spellCheck.dumpIncorrectWords();
			}

		} catch (FileNotFoundException e) {

			System.out.println(e);
		}
	}

}
