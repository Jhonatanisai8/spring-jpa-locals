package com.jhonatan.springdatajpa.controllers;

import com.jhonatan.springdatajpa.editor.ConvertCapEditor;
import com.jhonatan.springdatajpa.models.Address;
import com.jhonatan.springdatajpa.service.customerServiceImple.CustomerServiceImplementation;
import com.jhonatan.springdatajpa.validation.CustomerValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.jhonatan.springdatajpa.models.Customer;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@SessionAttributes("customer")
public class FormController {
    @Autowired
    private CustomerServiceImplementation service;

    @Autowired
    private CustomerValidador validador;

    @ModelAttribute("countrys")
    public List<String> countrys() {
        return List.of("EE.UU", "España", "Portugal", "Colombia");
    }

    //VALIDA AL MOMENTO QUE SE ENVIA EL FORMULARIO
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(validador);
        //binder.registerCustomEditor(String.class, new ConvertCapEditor());
        binder.registerCustomEditor(String.class, "firstName", new ConvertCapEditor());
        binder.registerCustomEditor(String.class, "lastName", new ConvertCapEditor());
        binder.registerCustomEditor(String.class, "country", new ConvertCapEditor());
        binder.registerCustomEditor(String.class, "address.city", new ConvertCapEditor());
        binder.registerCustomEditor(String.class, "address.mainStreet", new ConvertCapEditor());
        binder.registerCustomEditor(String.class, "address.secondaryStreet", new ConvertCapEditor());
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("tittle", "Registro de Datos.");
        model.addAttribute("tittleField", "Datos Personales");
        //objeto
        Customer customer = new Customer();
//        customer.setFirstName("John");
//        customer.setLastName("Smith");
//        customer.setEmail("john.smith@gmail.com");
//        Address address = new Address();
//        address.setCity("San Francisco");
//        address.setMainStreet("Main Street");
//        address.setSecondaryStreet("Secondary Street");
//        customer.setAddress(address);
        model.addAttribute("customer", customer);
        return "form";
    }

    @PostMapping("/form")
    public String processCustomerForm(
            @Valid Customer customer,
            BindingResult bindingResult,
            Model model,
            SessionStatus sessionStatus) {
        model.addAttribute("tittle", "Resultado de Registro de Datos.");
        if (bindingResult.hasErrors()) {
            return "form";
        }
        service.saveCustomer(customer);
        model.addAttribute("customer", customer);
        //reseteamos la sesion
        sessionStatus.setComplete();
        return "resultado";
    }
}
