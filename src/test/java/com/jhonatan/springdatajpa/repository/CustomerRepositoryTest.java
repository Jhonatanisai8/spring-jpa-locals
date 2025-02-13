package com.jhonatan.springdatajpa.repository;

import com.jhonatan.springdatajpa.models.Address;
import com.jhonatan.springdatajpa.models.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    public void findCustomerByFirstName() {
        Customer customer = repository.findByFirstName("test02").get();
        System.out.println(customer);
    }

    @Test
    public void findAllCustomers() {
        List<Customer> customers = repository.findAll();
        customers.forEach(System.out::println);
    }

    @Test
    public void saveCustomerWithAddressEmbeddable() {
        Address address = Address.builder()
                .city("city01")
                .mainStreet("mainCity01")
                .secondaryStreet("secondaryCity01")
                .build();

        Customer customer = Customer.builder()
                .firstName("test04")
                .lastName("test04")
                .email("test04@gmail.com")
                .address(address)
                .build();
        repository.save(customer);
    }

    @Test
    public void findCustomersByFirstNameContaining() {
        List<Customer> customers = repository.findByFirstNameContaining("lo");
        customers.forEach(System.out::println);
    }

    @Test
    public void findCsutomersByLastNameNotNull() {
        List<Customer> customerList = repository.findByLastNameNotNull();
        customerList.forEach(System.out::println);
    }

    @Test
    public void findCsutomersByAddress_City() {
        List<Customer> customerList = repository.findByAddress_City("Ciudad A");
        customerList.forEach(System.out::println);
    }

    @Test
    public void findCsutomersfindByAddress_MainStreet() {
        List<Customer> customerList = repository.findByAddress_MainStreet("Av. Ignacia Chefer");
        customerList.forEach(System.out::println);
    }

    @Test
    public void orderByCustomer() {
        List<Customer> customers = repository.findByFirstNameContainingOrderByFirstName("U");
        customers.forEach(System.out::println);
    }

    @Test
    public void getCustomerByEmailAddress() {
        Customer customer = repository.getCustomerByEmailAddress("damiangmail.com");
        System.out.println(customer);
    }

    @Test
    public void getCustomerFirstNameByEmailAddress() {
        String firstName = repository.getCustomerFirstNameByEmailAddress("damian@gmail.com");
        System.out.println(firstName);
    }

    @Test
    void getCustomerByEmailAddressNative() {
        Customer customer = repository.getCustomerByEmailAddressNative("damian@gmail.com");
        System.out.println(customer);
    }

    @Test
    void getCustomerByEmailAddressNativeParam() {
        Customer customer = repository.getCustomerByEmailAddressNativeParam("damian@gmail.com");
        System.out.println(customer);
    }

}