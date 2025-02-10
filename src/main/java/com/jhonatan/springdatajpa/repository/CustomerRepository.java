package com.jhonatan.springdatajpa.repository;

import com.jhonatan.springdatajpa.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository
        extends JpaRepository<Customer, Long> {
    Optional<Customer> findByFirstName(String firstName);
}
