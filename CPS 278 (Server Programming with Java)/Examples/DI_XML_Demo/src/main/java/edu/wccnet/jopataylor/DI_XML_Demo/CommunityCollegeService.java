package edu.wccnet.jopataylor.DI_XML_Demo;

public class CommunityCollegeService implements CollegeService {

	public String getService(String collegeName) {
		return collegeName + " is a Two Year Comunity College";
	}

}
