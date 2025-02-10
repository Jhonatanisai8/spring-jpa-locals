package com.jhonatan.springdatajpa.repository;

import com.jhonatan.springdatajpa.models.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository repository;

    @Test
    public void saveCustomer() {
        Customer customer = Customer.builder()
                .firstName("test02")
                .lastName("test02")
                .email("test02@gmail.com")
                .build();

        Customer customer01 = Customer.builder()
                .firstName("test01")
                .lastName("test01")
               // .email(null)
                .build();
        repository.save(customer);
    }
}