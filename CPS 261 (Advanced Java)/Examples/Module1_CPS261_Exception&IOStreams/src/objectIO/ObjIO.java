package objectIO;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Name implements Serializable {

	String firstName;
	String lastName;

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Name = [firstName = " + firstName + ", lastName = " + lastName + "]";
	}

}

class Student implements Serializable {

	String grade;
	Name name;

	public Student(String grade, Name name) {
		this.grade = grade;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student = [grade = " + grade + " " + name + "]";
	}

}

public class ObjIO {

	public static void main(String[] args) throws IOException {

		Student student1 = new Student("A", new Name("Jonathan", "Taylor"));
		Student student2 = new Student("B", new Name("Jing", "Bai"));

		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		Student student1FromIos;
		Student student2FromIos;

		try {

			oos = new ObjectOutputStream(new FileOutputStream("objOut.data"));

			oos.writeObject(student1);
			oos.writeObject(student2);

			ois = new ObjectInputStream(new FileInputStream("objOut.data"));

			boolean eof = false;
			while (!eof) {
				try {
					System.out.println((Student) ois.readObject());
				} catch (EOFException e) {
					eof = true;
				}
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			oos.close();
		}

	}

}
