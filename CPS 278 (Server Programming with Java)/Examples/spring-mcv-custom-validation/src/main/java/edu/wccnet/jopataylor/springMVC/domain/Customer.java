package edu.wccnet.jopataylor.springMVC.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import edu.wccnet.jopataylor.springMVC.validation.CourseName;

public class Customer {

	@NotBlank(message = "Field is Required")
	@Size(min = 4, message = "Name Has To Be At Least 4 Characters Long")
	private String name;

	@Min(value = 18, message = "You Have To Be At Least 18")
	private int age;

	@NotBlank
	@Pattern(regexp = "^[0-9]{5}", message = "Zip Code Should Be 5 Digits")
	private String zipcode;

	@CourseName()
	private String favoriteCourse;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getFavoriteCourse() {
		return favoriteCourse;
	}

	public void setFavoriteCourse(String favoriteCourse) {
		this.favoriteCourse = favoriteCourse;
	}

}
