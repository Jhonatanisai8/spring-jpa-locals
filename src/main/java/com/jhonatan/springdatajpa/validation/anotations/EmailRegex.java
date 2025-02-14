package com.jhonatan.springdatajpa.validation.anotations;

import com.jhonatan.springdatajpa.validation.EmailRegexValidador;
import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailRegexValidador.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EmailRegex {
    java.lang.String message() default "Formato de correo invalido desde anotacion";

    java.lang.Class<?>[] groups() default {};

    java.lang.Class<? extends jakarta.validation.Payload>[] payload() default {};

}
