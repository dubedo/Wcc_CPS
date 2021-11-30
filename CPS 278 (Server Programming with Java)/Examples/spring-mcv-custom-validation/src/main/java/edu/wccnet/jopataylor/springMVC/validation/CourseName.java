package edu.wccnet.jopataylor.springMVC.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseNameConstraintValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseName {

	public String[] value() default { "CPS", "CIS", "CNT" };

	public String message() default "Course has to Start With CPS, CIS, or CNT";

	public Class<?>[] groups() default {};

	public Class<? extends Payload>[] payload() default {};
}
