package com.jhonatan.springdatajpa.validation;

import com.jhonatan.springdatajpa.validation.anotations.EmailRegex;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailRegexValidador
        implements ConstraintValidator<EmailRegex, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (!value.matches("(?i)^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")) {
            return false;
        }
        return true;
    }
}
