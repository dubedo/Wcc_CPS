package edu.wccnet.jopataylor.springMVC.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseNameConstraintValidator implements ConstraintValidator<CourseName, String> {

	private String[] prefixCourseName;

	@Override
	public void initialize(CourseName courseName) {

		prefixCourseName = courseName.value();

	}

	@Override
	public boolean isValid(String userInput, ConstraintValidatorContext arg1) {

		// Says that if the UserInput IS null. True. If not? check to see if it starts
		// with what we want it to start with

		boolean result;

		if (userInput != null) {
			for (String eachPrefix : prefixCourseName) {
				result = userInput.startsWith(eachPrefix);

				if (result) {
					return result;
				}
			}

			return false;
		} else {
			return true;
		}

	}

}
