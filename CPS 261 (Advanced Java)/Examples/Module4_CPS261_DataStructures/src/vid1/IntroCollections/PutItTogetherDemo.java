package vid1.IntroCollections;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PutItTogetherDemo {

	public static int countWords(String fileName) {

		int counter = 0;
		String[] keywordsAsStrings = { "abstract", "assert", "boolean", "break", "catch", "class", "const", "continue",
				"do", "while", "else", "for", "finally", "int", "if", "import", "package", "short", "protected",
				"public", "true", "false", "super", "throw", "null" };

		Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordsAsStrings));

		Scanner fileInput = null;

		fileName = "C:\\Users\\idube\\Eclipse Workspace\\Module4_CPS261_DataStructures\\src\\vid1\\IntroCollections\\"
				+ fileName;

		try {

			fileInput = new Scanner(new FileInputStream(fileName));

			while (fileInput.hasNext()) {

				String word = fileInput.next();

				if (keywordSet.contains(word)) {
					System.out.println(word);
					counter++;
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			fileInput.close();
		}

		return counter;

	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter A Java Source File");
		String fileName = input.nextLine();

		System.out.println(countWords(fileName));

		input.close();
	}
}
