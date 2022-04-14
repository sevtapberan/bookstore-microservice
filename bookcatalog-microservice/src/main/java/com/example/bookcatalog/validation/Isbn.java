package com.example.bookcatalog.validation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=IsbnValidator.class)
public @interface Isbn {
	String message() default "{validation.isbn}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
