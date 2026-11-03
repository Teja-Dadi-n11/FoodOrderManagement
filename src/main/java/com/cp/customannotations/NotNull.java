package com.cp.customannotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = NotNullCustomValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER ,ElementType.ANNOTATION_TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface NotNull {

	String message() default "The field must not be null";
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
