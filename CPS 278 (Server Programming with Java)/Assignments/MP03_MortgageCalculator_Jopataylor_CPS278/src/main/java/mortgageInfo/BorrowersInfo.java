package mortgageInfo;

import java.util.ArrayList;

public class BorrowersInfo {

	private double principalLoan;
	private double downPayment;
	private double interestRate;
	private int loanTerm;

	private double monthlyPayment;

	private ArrayList<MonthlyBreakdown> theBreakdown;

	public double getPrincipalLoan() {
		return principalLoan;
	}

	public void setPrincipalLoan(double principalLoan) {
		this.principalLoan = principalLoan;
	}

	public double getDownPayment() {
		return downPayment;
	}

	public void setDownPayment(double downPayment) {
		this.downPayment = downPayment;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getLoanTerm() {
		return loanTerm;
	}

	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public ArrayList<MonthlyBreakdown> getTheBreakdown() {
		return theBreakdown;
	}

	public void setTheBreakdown(ArrayList<MonthlyBreakdown> theBreakdown) {
		this.theBreakdown = theBreakdown;
	}

	public void calculateMonthlyPayment() {

		int termInMonths = loanTerm * 12;
		double rateInMonths = interestRate / 12;

		double rn1 = Math.pow((1 + rateInMonths), termInMonths);

		monthlyPayment = (principalLoan - downPayment) * (rateInMonths * rn1 / ((rn1) - 1));
	}

	public void generateTable() {
		MonthlyBreakdown monthlyBreakdown;
		theBreakdown = new ArrayList<>();

		double newLoanBalance, principalPaid;

		double rateInMonths = interestRate / 12;
		int day = 0;

		newLoanBalance = principalLoan - downPayment;

		while (newLoanBalance > 0) {
			monthlyBreakdown = new MonthlyBreakdown();
			monthlyBreakdown.setMonthNumber(++day);

			if (newLoanBalance < monthlyPayment) {
				monthlyBreakdown.setPrincipalPaid(newLoanBalance);
				monthlyBreakdown.setNewLoanBalance(0);
				monthlyBreakdown.setInterestPaid(0);
				newLoanBalance = 0;
			} else {
				principalPaid = monthlyPayment - (newLoanBalance * rateInMonths);
				monthlyBreakdown.setInterestPaid(monthlyPayment - principalPaid);
				monthlyBreakdown.setPrincipalPaid(principalPaid);

				newLoanBalance = newLoanBalance - principalPaid;
				monthlyBreakdown.setNewLoanBalance(newLoanBalance);
			}
			
			theBreakdown.add(monthlyBreakdown);

		}

	}

}
