package edu.wccnet.jopataylor.DI_XML_Demo;

public class UniversityService implements CollegeService {

	public String getService(String collegeName) {
		return collegeName + " is a Four Year University";
	}

}
