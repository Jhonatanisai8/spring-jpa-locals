package com.jhonatan.springdatajpa.validation;

import com.jhonatan.springdatajpa.models.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CustomerValidador
        implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //Customer customer = (Customer) target;
        //si esta vacio o tiene espacios en blanco
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.city", "NotEmpty");

//        //otra forma de validar
//        if (!customer.getEmail().matches("(?i)^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")) {
//            errors.rejectValue("email", "Pattern.customer.email", "El formato del correo es inválido");
//        }

//        if (customer.getPhone() == null) {
//            errors.rejectValue("phone", "Min.customer.phone", "El número de teléfono debe tener exactamente 9 dígitos.");
//            return;
//        }
//        if (customer.getPhone() <= 900000000) {
//            errors.rejectValue("phone", "Min.customer.phone", "El número de teléfono debe tener exactamente 9 dígitos.");
//        }
//        if (customer.getPhone() >= 999999999) {
//            errors.rejectValue("phone", "Max.customer.phone", "El número de teléfono debe tener exactamente 9 dígitos.");
//        }

    }
}
