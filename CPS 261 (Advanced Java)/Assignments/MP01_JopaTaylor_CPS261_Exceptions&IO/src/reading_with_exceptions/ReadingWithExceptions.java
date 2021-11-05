package reading_with_exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadingWithExceptions {

	public void process(String inputFilename) {

		Scanner scanIn = null;
		PrintWriter printOut = null;

		try {
			scanIn = new Scanner(new FileInputStream(inputFilename));
		} catch (FileNotFoundException e) {
			System.out.println("Not a Valid File");
			return;
		}

		int toCount = 0;
		String outputFileName = scanIn.next();

		try {
			printOut = new PrintWriter(new FileOutputStream(outputFileName));
		} catch (FileNotFoundException e) {
			System.out.println("Can't Find a File to Write To.");
			e.printStackTrace();
		}

		if (scanIn.hasNextInt()) {
			toCount = scanIn.nextInt();
		} else {
			toCount = -1;
			scanIn.next();
			System.out.println("Reading All Integers");
		}

		copyNumbers(scanIn, printOut, toCount);

		scanIn.close();
		printOut.close();

		printToScreen(outputFileName);

	}

	public void copyNumbers(Scanner scanner, PrintWriter pw, int numToRead) {

		int counter = 0;

		while ((scanner.hasNext() && counter < numToRead || (scanner.hasNext() && numToRead == -1))) {

			if (scanner.hasNextInt()) {

				pw.print(scanner.nextInt() + " ");

				counter++;

				if (counter % 10 == 0) {
					pw.println();
				}

			} else {
				scanner.next();
			}
		}

	}

	public void printToScreen(String fileName) {

		Scanner scanIn = null;

		try {

			scanIn = new Scanner(new FileInputStream(fileName));

			while (scanIn.hasNextLine()) {
				System.out.println(scanIn.nextLine());
			}

		} catch (FileNotFoundException e) {
			System.out.println("printToScreen can't open: " + fileName);
		} finally {
			if (scanIn != null) {
				scanIn.close();
			}
		}

	}

	public static void main(String[] args) {

		ReadingWithExceptions instance = new ReadingWithExceptions();

		for (int i = 0; i < args.length; i++) {
			System.out.println("Processing " + args[i]);

			instance.process(args[i]);

		}

	}

}
