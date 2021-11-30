package sortDemo;

import java.time.LocalDate;

public class HourlyEmployee extends Employee {

	private double hourlyRate;
	private double hoursWorked;

	public HourlyEmployee(String name, LocalDate hiredDate, double hourlyRate, double hoursWorked) {
		super(name, hiredDate);
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}

	public HourlyEmployee(String name, double hourlyRate, double hoursWorked) {
		this(name, LocalDate.now(), hourlyRate, hoursWorked);
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public void printPay() {
		System.out.println("Pay Info: " + hoursWorked * hourlyRate);
	}

	public double getPay() {
		return hoursWorked * hourlyRate;
	}

	@Override
	public String toString() {
		return super.toString() + ". ***** HourlyEmployee [hourlyRate=" + hourlyRate + ", hoursWorked=" + hoursWorked
				+ "] ***** Pay Info: " + getPay();
	}

}
