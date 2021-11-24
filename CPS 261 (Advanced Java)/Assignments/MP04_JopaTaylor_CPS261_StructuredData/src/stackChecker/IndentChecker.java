package stackChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

@SuppressWarnings("serial")
class BadIndentationException extends RuntimeException {

	BadIndentationException(String error) {
		super(error);
	}

}

public class IndentChecker {
	Stack<Integer> indentStack = new Stack<Integer>();

	private int findFirstNonBlank(String line) {

		if (line.strip().isEmpty())
			return -1;
		return line.length() - line.stripLeading().length();
	}

	private void processLine(String line, int lineNumber) {
		System.out.printf("%3d:%s\n", lineNumber, line);
		int index = findFirstNonBlank(line);

		if (index == -1) {
			return;
		}

		if (indentStack.isEmpty()) {
			indentStack.push(index);
			return;
		}

		if (index > indentStack.peek()) {
			indentStack.push(index);
			return;
		}

		while (indentStack.peek() > index) {
			indentStack.pop();
		}

		if (indentStack.peek() != index) {
			throw new BadIndentationException("Error found on line: " + lineNumber);
		}

	}

	public void checkIndentation(String fileName) {

		indentStack.clear();

		Scanner input = null;

		try {
			input = new Scanner(new File(fileName));
			int lineCounter = 1;

			while (input.hasNextLine()) {
				processLine(input.nextLine(), lineCounter++);
			}
			System.out.println(fileName + " is Properly Indented.");
		}

		catch (BadIndentationException error) {
			System.out.println(error);
		}

		catch (FileNotFoundException e) {
			System.out.println("Can't open file: " + fileName);
		}

		finally {

			if (input != null)
				input.close();
		}

	}

	public static void main(String[] args) {
		IndentChecker indentChecker = new IndentChecker();

		for (int i = 0; i < args.length; i++) {
			System.out.println("Processing file: " + args[i]);
			indentChecker.checkIndentation(args[i]);
		}
	}
}