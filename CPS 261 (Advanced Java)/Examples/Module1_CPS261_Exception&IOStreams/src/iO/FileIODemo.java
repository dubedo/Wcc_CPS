package iO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIODemo {

	public static void main(String[] args) throws IOException {

		FileReader fileIn = null;
		Scanner scannerIn = null;

		FileWriter fileOut = null;
		PrintWriter printOut = null;

		int c;

		try {

			fileIn = new FileReader("input.txt");
			scannerIn = new Scanner(new FileInputStream("input.txt"));

			c = fileIn.read();

			fileOut = new FileWriter("output.txt");
			printOut = new PrintWriter(new FileOutputStream("printwriter_output.txt"));
			// IF WE WANTED TO APPEND
			// printOut = new PrintWriter(new FileOutputStream("printwriter_output.txt"));

			while (c != -1) {

				System.out.println((char) c);

				fileOut.write(c);
				c = fileIn.read();

			}

			while (scannerIn.hasNext()) {
				// System.out.println(scannerIn.next());
				printOut.println(scannerIn.next());
			}

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fileIn.close();
			scannerIn.close();
			fileOut.close();
			printOut.close();
		}

	}

}
