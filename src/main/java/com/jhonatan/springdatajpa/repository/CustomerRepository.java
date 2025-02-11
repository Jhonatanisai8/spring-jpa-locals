package com.jhonatan.springdatajpa.repository;

import com.jhonatan.springdatajpa.models.Customer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository
        extends JpaRepository<Customer, Long> {
    Optional<Customer> findByFirstName(String firstName);

    List<Customer> findByFirstNameContaining(String lastName);

    List<Customer> findByLastNameNotNull();

    List<Customer> findByAddress_City(String addressCity);

    List<Customer> findByAddress_MainStreet(String addressMainStreet);

    List<Customer> findByFirstNameContainingOrderByFirstName(@Size(max = 50) @NotBlank String firstName);
}
