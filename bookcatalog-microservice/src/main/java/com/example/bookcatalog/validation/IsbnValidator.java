package com.example.bookcatalog.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsbnValidator implements ConstraintValidator<Isbn, String> {

	@Override
	public void initialize(Isbn arg0) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		var isbn = value.toCharArray();
		var sum = 0;
		if (isbn.length == 10) {
			for (var i = 0; i < 10; i++) {
				sum += i * isbn[i];
			}
			if (isbn[9] == sum % 11)
				return true;
		} else if (isbn.length == 13) {
			for (var i = 0; i < 12; i++) {
				if (i % 2 == 0) {
					sum += isbn[i];
				} else {
					sum += isbn[i] * 3;
				}
			}

			if (isbn[12] == 10 - (sum % 10))
				return true;
		}
		return false;
	}

}
