package sortDemo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDemo {

	public static void main(String[] args) {

		Employee first = new HourlyEmployee("Jing", 80, 45);
		Employee second = new HourlyEmployee("Jonathan", 80, 30);

		first.setHiredDate(LocalDate.of(2005, 6, 27));

		List<Employee> employees = new ArrayList<>();

		employees.add(first);
		employees.add(second);

		employees.sort((emp1, emp2) -> {
			return emp1.getHiredDate().compareTo(emp2.getHiredDate());
		});

		for (Employee employee : employees) {
			System.out.println(employee);
		}

		System.out.println();
		System.out.println();

		employees.sort((emp1, emp2) -> {

			if (emp1.getPay() > emp2.getPay()) {

				return 1;
			} else if (emp1.getPay() < emp2.getPay()) {

				return -1;
			} else {

				return 0;
			}
		});

		for (Employee employee : employees) {
			System.out.println(employee);
		}

		System.out.println();
		System.out.println();

		Collections.sort(employees, (emp1, emp2) -> {
			return emp1.getHiredDate().compareTo(emp2.getHiredDate());
		});

		for (Employee employee : employees) {
			System.out.println(employee);
		}

		System.out.println();
		System.out.println();

	}

}
