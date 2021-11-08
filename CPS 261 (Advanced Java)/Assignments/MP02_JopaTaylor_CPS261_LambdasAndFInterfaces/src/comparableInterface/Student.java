package comparableInterface;

public class Student implements Comparable<Student> {

	public static int currentStudentId = 0;

	private int studentId;
	private double gpa;
	private String name;

	public Student() {

	}

	public Student(double gpa, String name) {
		this.studentId = currentStudentId++;
		this.gpa = gpa;
		this.name = name;
	}

	public static int getCurrentStudentId() {
		return currentStudentId;
	}

	public static void setCurrentStudentId(int currentStudentId) {
		Student.currentStudentId = currentStudentId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Student: " + name + ". Id = " + studentId + ". GPA = " + gpa;
	}

	public int compareTo(Student secondStudent) {

		if (getStudentId() > secondStudent.getStudentId()) {
			return 1;
		} else if (getStudentId() < secondStudent.getStudentId()) {
			return -1;
		} else {
			return 0;
		}

	}

	/*
	 * public int compareTo(Student secondStudent) {
	 * 
	 * if (getName().compareTo(secondStudent.getName()) > 0) { return 1; } else if
	 * (getName().compareTo(secondStudent.getName()) < 0) { return -1; } else {
	 * return 0; }
	 * 
	 * }
	 */

}
