package personIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

@SuppressWarnings("serial")
class Person implements Serializable {

	int age;
	String name;

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}

}

public class PersonIO {

	static Scanner input = new Scanner(System.in);
	String fileName;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;

	public PersonIO(String fileName) {

		this.fileName = fileName;

		try {
			oos = new ObjectOutputStream(new FileOutputStream(this.fileName, true));
			ois = new ObjectInputStream(new FileInputStream(this.fileName));
		} catch (IOException e) {
			System.out.println("Input/Output Exception");
			e.printStackTrace();
		}

	}

	public void add(String name, int age) {

		Person personToWrite = new Person(age, name);

		try {
			oos.writeObject(personToWrite);
		} catch (IOException e) {
			System.out.println("Input/Output Exception");
			e.printStackTrace();
		}

	}

	public void display() {

		boolean endOfFile = false;

		while (!endOfFile) {

			try {
				System.out.println((Person) ois.readObject());
			} catch (IOException | ClassNotFoundException e) {
				endOfFile = true;
			}

		}

	}

	public static void main(String[] args) throws IOException {

		PersonIO streamPeople = new PersonIO("people.data");

		try {

			int option = -1;

			while (option != 0) {

				System.out.println("Please choose an option:");
				System.out.println("0: quit");
				System.out.println("1: add");
				System.out.println("2: display");

				option = input.nextInt();
				input.nextLine();

				switch (option) {

				case 0:
					System.out.println("Bye");
					break;

				case 1:
					int age;
					String name;

					System.out.println("Please enter a Persons Name");
					name = input.nextLine();
					System.out.println("Please enter a Persons Age");
					age = input.nextInt();

					streamPeople.add(name, age);
					break;

				case 2:
					System.out.println("The List of People:");
					streamPeople.display();
					break;

				}

			}

		} finally {

			streamPeople.ois.close();
			streamPeople.oos.close();
		}

	}

}