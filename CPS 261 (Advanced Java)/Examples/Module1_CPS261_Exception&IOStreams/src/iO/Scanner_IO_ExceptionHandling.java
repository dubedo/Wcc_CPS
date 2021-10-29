package iO;

import java.io.*;
import java.util.*;

public class Scanner_IO_ExceptionHandling {

	void readMixedData(Scanner scanner, PrintStream printStream) {

		while (scanner.hasNext()) {
			String name = scanner.next();
			int homeRuns = scanner.nextInt();
			double battingAverage = scanner.nextDouble();

			printStream.printf("%s has %d home runs and has a %.3f batting average%n", name, homeRuns, battingAverage);

		}

	}

	void readMixedData2(Scanner scanner, PrintStream printStream) {

		while (scanner.hasNext()) {

			try {
				String name = scanner.next();
				int homeRuns = scanner.nextInt();
				double battingAverage = scanner.nextDouble();

				printStream.printf("%s has %d home runs and has a %.3f batting average%n", name, homeRuns,
						battingAverage);

			} catch (InputMismatchException e) {

				System.out.println("Skipping Line: " + e);
				scanner.nextLine(); // Skips the Remainder of the Line.

			}

		}

	}

	void readMixedData3(Scanner scanner, PrintStream printStream) {

		while (scanner.hasNext()) {

			String name = scanner.next();

			int homeRuns = -1;
			if (scanner.hasNextInt()) {
				homeRuns = scanner.nextInt();
			} else {
				// The Following Skips the Bad Input
				System.out.println("Bad Home Run Input: " + scanner.next() + " defaulting to -1.");
			}

			double battingAverage = -1;
			if (scanner.hasNextDouble()) {
				battingAverage = scanner.nextDouble();
			} else {
				// The Following Skips the Bad Input
				System.out.println("Bad Batting Average Input: " + scanner.next() + " defaulting to -1.");
			}

			printStream.printf("%s has %d home runs and has a %.3f batting average%n", name, homeRuns, battingAverage);

		}

	}

	void readMixedData4(Scanner scanner, PrintStream printStream) {

		while (scanner.hasNext()) {
			String name = scanner.nextLine();

			int homeRuns = -1;
			if (scanner.hasNextInt()) {
				homeRuns = scanner.nextInt();
			} else {
				// The Following Skips the Bad Input
				System.out.println("Bad Home Run Input: " + scanner.next() + " defaulting to -1");
			}

			double battingAverage = -1;
			if (scanner.hasNextDouble()) {
				battingAverage = scanner.nextDouble();
			} else {
				// The Following Skips the Bad Input
				System.out.println("Bad Batting Average Input: " + scanner.next() + " defaulting to -1");
			}

			printStream.printf("%s has %d home runs and has a %.3f batting average%n", name, homeRuns, battingAverage);

			if (scanner.hasNextLine()) {
				scanner.nextLine(); // Need to Go to the Next Line.
			}

		}

	}

	void process(String inputFileName, String outputFileName) {
		Scanner scanIn = null;
		PrintStream printOut = null;

		try {
			scanIn = new Scanner(new FileInputStream(inputFileName));
			printOut = new PrintStream(new FileOutputStream(outputFileName));

			// readMixedData(scanIn, printOut);
			// readMixedData2(scanIn, printOut);

			// Best Case for badBaseball.txt
			readMixedData3(scanIn, printOut);

			// Best Case for badBaseballLines.txt
			// readMixedData4(scanIn, printOut);

		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e);
		} finally {

			if (scanIn != null) {
				scanIn.close();
			}

			if (printOut != null) {
				printOut.close();
			}

		}

	}

	public static void main(String[] args) {
		Scanner_IO_ExceptionHandling instanceOfCMD = new Scanner_IO_ExceptionHandling();

		instanceOfCMD.process(args[0], args[1]);

	}

}