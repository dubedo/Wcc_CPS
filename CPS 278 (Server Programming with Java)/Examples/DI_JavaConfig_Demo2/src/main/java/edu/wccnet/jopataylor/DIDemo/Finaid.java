package edu.wccnet.jopataylor.DIDemo;

public class Finaid {

	private College college;
	private FinaidService finaidService;

	public Finaid() {

	}

	public Finaid(College college, FinaidService finaidService) {
		this.college = college;
		this.finaidService = finaidService;
	}

	public void displayFinaid() {
		System.out.println("You've Recieved " + finaidService.getFinAidType() + " from " + college.getCollegeName());
	}

}
