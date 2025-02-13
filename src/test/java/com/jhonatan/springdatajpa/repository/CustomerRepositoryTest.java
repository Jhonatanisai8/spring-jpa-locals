package com.jhonatan.springdatajpa.repository;

import com.jhonatan.springdatajpa.models.Address;
import com.jhonatan.springdatajpa.models.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

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

    @Test
    void countCustomerByAddress_City() {
        int numero = repository.countCustomerByAddress_City("Ciudad A");
        assertTrue(numero > 0);
    }

    @Test
    void getCustomerByAddress_CityNative() {
        List<Object[]> customerByAddressCityNative = repository.getCustomerByAddress_CityNative();
        for (Object[] row : customerByAddressCityNative) {
            Integer count = ((Number) row[0]).intValue();
            String city = (String) row[1];
            System.out.println(city + ", Customer: " + count);
        }
    }

    @Test
    void updateCustomeFirstNameByEmailAddress() {
        repository.updateCustomeFirstNameByEmailAddress("David Eli", "cmartinez5@email.com");
    }

    @Test
    void updateCustomerAddressByFirstNameNative() {
        String customerCity = "city01";
        String customerMainStreet = "mainStreet01";
        String customerSecondaryStreet = "secondaryStreet01";
        String firstName = "David Eli";
        repository.updateCustomerAddressByFirstNameNative(customerCity, customerMainStreet, customerSecondaryStreet, firstName);
    }

    @Test
    void updateEmailAddressByFirstNameAndLastNameNative() {
        String emailAddress = "test04@gmail.com";
        String firstName = "David Eli";
        String lastName = "Martínez";
        repository.updateEmailAddressByFirstNameAndLastNameNative(emailAddress, firstName, lastName);
    }
}