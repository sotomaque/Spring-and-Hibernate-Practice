package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
		
		private String coursePrefix;
		
		@Override
		public void initialize(CourseCode theCourseCode) {
			coursePrefix = theCourseCode.value();
		}

		// theCode is data from the form
		// the second parameter is to add additional error messages if needed
		@Override
		public boolean isValid(String theCode, 
				ConstraintValidatorContext theConstraintValidatorContext) {

			boolean result;
			
			// must ensure its not equal to null otherwise we will get a null pointer exception
			if (theCode != null) {
				result = theCode.startsWith(coursePrefix);
			} else {
				result = true;
			}
			
			return result;
		}
		
}


