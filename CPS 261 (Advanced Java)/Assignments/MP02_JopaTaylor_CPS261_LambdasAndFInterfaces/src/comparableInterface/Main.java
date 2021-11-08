package comparableInterface;

public class Main {

	public static void main(String[] args) {

		Student[] studentArray = new Student[4];

		studentArray[0] = new Student(4.0, "a");
		studentArray[1] = new Student(2.0, "c");
		studentArray[3] = new Student(1.0, "a");
		studentArray[2] = new Student(3.0, "b");

		System.out.println("Before Sorting");
		System.out.println();

		for (Student student : studentArray) {
			System.out.println(student);
		}

		System.out.println();
		System.out.println("Sorted Array");
		System.out.println();

		SelectionSort.sort(studentArray);

		for (Student student : studentArray) {
			System.out.println(student);
		}
	}

}
