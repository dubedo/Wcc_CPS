package sortDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlatMapDemo {

	public static void main(String[] args) {

		Course cps161 = new Course("CPS161", 4);
		Course cps261 = new Course("CPS261", 3);
		Course mth100 = new Course("MATH100", 7);

		Department computer = new Department("Computer");
		Department math = new Department("Math");

		computer.addCourse(cps161);
		computer.addCourse(cps261);

		math.addCourse(mth100);

		List<Department> departments = new ArrayList<>();

		// The List of Lists

		departments.add(computer);
		departments.add(math);

		// This does the Same Thing

		departments.stream().flatMap(department -> department.getCourse().stream())
				.filter(course -> course.getName().startsWith("C")).sorted((c1, c2) -> c1.getCredit() - c2.getCredit())
				.forEach(System.out::println);

		System.out.println();
		System.out.println("****** Give it Some Space *******");
		System.out.println();

		// A way to Compare and Boil down until one Result is Left (Highest Credit Hour
		// Class Here)

		departments.stream().flatMap(department -> department.getCourse().stream())
				.reduce((c1, c2) -> c1.getCredit() > c2.getCredit() ? c1 : c2).ifPresent(System.out::println);

		System.out.println();
		System.out.println("****** Give it Some Space *******");
		System.out.println();

		// A way to store a chunk of information to a Data Set for later user. Maps need
		// Keys that can't be duplicated.

		List<Course> courseList = new ArrayList<>();
		Map<Course, Integer> courseMap = new HashMap<>();

		courseList = departments.stream().flatMap(department -> department.getCourse().stream())
				.collect((Collectors.toList()));

		for (Course course : courseList) {
			System.out.println(course);
		}

		System.out.println();

		courseMap = departments.stream().flatMap(department -> department.getCourse().stream())
				.collect((Collectors.toMap(e -> e, e -> e.getCredit())));

		System.out.println(courseMap);

		System.out.println();
		System.out.println("****** Give it Some Space *******");
		System.out.println();

		System.out.println(departments.stream().flatMap(department -> department.getCourse().stream())
				.collect(Collectors.groupingBy(e -> e.getName().length(), Collectors.counting())));

	}

}

class Course {
	private String name;
	private int credit;

	public Course(String name, int credit) {
		this.name = name;
		this.credit = credit;
	}

	public String getName() {
		return name;
	}

	public int getCredit() {
		return credit;
	}

	@Override
	public String toString() {
		return name;
	}

}

class Department {
	@SuppressWarnings("unused")
	private String name;

	List<Course> courses;

	public Department(String name) {
		this.name = name;
		courses = new ArrayList<>();
	}

	public void addCourse(Course course) {
		courses.add(course);
	}

	public List<Course> getCourse() {
		return courses;
	}

}
