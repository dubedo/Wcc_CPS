package edu.wccnet.jopataylor.DIDemo;

public class UniversityService implements CollegeService {

	public String getService(String collegeName) {
		return collegeName + " is a Four Year University";
	}

}
