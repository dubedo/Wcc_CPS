package edu.wccnet.jopataylor.DI_XML_Demo;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class College {

	private String collegeName;
	private int yearBuilt, zipCode, enrollment;
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

		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("beanConfig.xml");

		College college = (College) context.getBean("college");

		System.out.println(college.toString());

		college.printCollegeService();

		Finaid finaid = (Finaid) context.getBean("finaid");
		finaid.displayFinaid();

		((FileSystemXmlApplicationContext) context).close();

	}

}
