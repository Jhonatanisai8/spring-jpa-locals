package com.jhonatan.springdatajpa.controllers;

import com.jhonatan.springdatajpa.models.Address;
import com.jhonatan.springdatajpa.service.customerServiceImple.CustomerServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.jhonatan.springdatajpa.models.Customer;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("customer")
public class FormController {
    @Autowired
    private CustomerServiceImplementation service;

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("tittle", "Registro de Datos.");
        //objeto
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Smith");
        customer.setEmail("john.smith@gmail.com");
        Address address = new Address();
        address.setCity("San Francisco");
        address.setMainStreet("Main Street");
        address.setSecondaryStreet("Secondary Street");
        customer.setAddress(address);
        model.addAttribute("customer", customer);
        return "form";
    }

    @PostMapping("/form")
    public String processCustomerForm(@Valid Address address,
                                      @Valid Customer customer,
                                      BindingResult bindingResult,
                                      Model model,
                                      SessionStatus sessionStatus) {
        model.addAttribute("tittle", "Resultado de Registro de Datos.");
        if (bindingResult.hasErrors()) {
            return "form";
        }
        customer.setAddress(address);
        service.saveCustomer(customer);
        model.addAttribute("customer", customer);
        sessionStatus.setComplete();
        return "resultado";
    }
}
