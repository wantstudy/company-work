package com.test.annotions;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyValidator implements ConstraintValidator<Validotion, String> {
	
	public void initialize(Validotion arg0) {
		// TODO Auto-generated method stub
		
	}

	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
