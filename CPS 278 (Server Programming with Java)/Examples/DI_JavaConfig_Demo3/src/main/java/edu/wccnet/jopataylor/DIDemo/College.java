package edu.wccnet.jopataylor.DIDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component("wcc")
public class College {

	@Value("${collegeName}")
	private String collegeName;
	@Value("${yearBuilt}")
	private int yearBuilt;
	@Value("${zipCode}")
	private int zipCode;
	private int enrollment;
	private CollegeService collegeService;

	public College(String collegeName, int yearBuilt) {

		this.collegeName = collegeName;
		this.yearBuilt = yearBuilt;

	}

	public College() {

	}

	@Override
	public String toString() {

		return "College [collegeName=" + collegeName + ", yearBuilt=" + yearBuilt + ", zipCode=" + zipCode
				+ ", enrollment=" + enrollment + "]";

	}

	public void printCollegeService() {
		System.out.println(collegeService.getService(collegeName));
	}

	@Autowired
	@Qualifier("communityCollegeService")
	public void setCollegeService(CollegeService collegeService) {
		this.collegeService = collegeService;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public void setEnrollment(int enrollment) {
		this.enrollment = enrollment;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIDemoJavaConfig.class);

		College college = (College) context.getBean("wcc");

		System.out.println(college.toString());

		college.printCollegeService();

		Finaid finaid = (Finaid) context.getBean("finaid");
		finaid.displayFinaid();

		context.close();

	}

}
