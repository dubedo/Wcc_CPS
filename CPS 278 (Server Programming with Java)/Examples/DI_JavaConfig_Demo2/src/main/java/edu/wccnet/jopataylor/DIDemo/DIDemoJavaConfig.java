package edu.wccnet.jopataylor.DIDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIDemoJavaConfig {

	@Bean
	public College wcc() {

		College myCollege = new College();
		myCollege.setCollegeService(communityCollegeService());

		return myCollege;

	}

	@Bean
	public CommunityCollegeService communityCollegeService() {

		return new CommunityCollegeService();
	}

	@Bean
	public Finaid finaid() {

		return new Finaid(wcc(), scholarships());
	}

	@Bean
	public Scholarships scholarships() {

		return new Scholarships();
	}

}
