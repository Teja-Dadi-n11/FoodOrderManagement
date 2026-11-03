package com.cp.customannotations;

import jakarta.validation.ConstraintValidator;

import jakarta.validation.ConstraintValidatorContext;

public class NotNullCustomValidator implements ConstraintValidator<NotNull, Object> {

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {

		return value != null;
	}

}