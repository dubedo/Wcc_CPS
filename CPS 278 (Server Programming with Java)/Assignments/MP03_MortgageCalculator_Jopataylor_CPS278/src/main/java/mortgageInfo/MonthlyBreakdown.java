package mortgageInfo;

public class MonthlyBreakdown {

	private double newLoanBalance;
	private double principalPaid;
	private double interestPaid;
	private int monthNumber;

	public double getNewLoanBalance() {
		return newLoanBalance;
	}

	public void setNewLoanBalance(double newLoanBalance) {
		this.newLoanBalance = newLoanBalance;
	}

	public double getPrincipalPaid() {
		return principalPaid;
	}

	public void setPrincipalPaid(double principalPaid) {
		this.principalPaid = principalPaid;
	}

	public double getInterestPaid() {
		return interestPaid;
	}

	public void setInterestPaid(double interestPaid) {
		this.interestPaid = interestPaid;
	}

	public int getMonthNumber() {
		return monthNumber;
	}

	public void setMonthNumber(int monthNumber) {
		this.monthNumber = monthNumber;
	}

}
