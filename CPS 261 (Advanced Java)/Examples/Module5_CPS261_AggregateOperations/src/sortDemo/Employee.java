package sortDemo;

import java.time.LocalDate;

public abstract class Employee {

	private String name;
	private LocalDate hiredDate;

	public Employee(String name, LocalDate hiredDate) {
		super();
		this.name = name;
		this.hiredDate = hiredDate;
	}

	public Employee(String name) {
		this(name, LocalDate.now());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(LocalDate hiredDate) {
		this.hiredDate = hiredDate;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", hiredDate=" + hiredDate + "]";
	}

	public abstract void printPay();

	public abstract double getPay();

}
