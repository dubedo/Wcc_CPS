package edu.wccnet.jopataylor.DIDemo;

import org.springframework.stereotype.Component;

@Component
public class CommunityCollegeService implements CollegeService {

	public String getService(String collegeName) {
		return collegeName + " is a Two Year Comunity College";
	}

}
