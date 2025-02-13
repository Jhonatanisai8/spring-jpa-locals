package com.jhonatan.springdatajpa.repository;

import com.jhonatan.springdatajpa.models.Customer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
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

    @Query("SELECT c FROM Customer c where  c.email =?1")
    Customer getCustomerByEmailAddress(String email);

    @Query("SELECT c.firstName FROM Customer c where c.email =?1")
    String getCustomerFirstNameByEmailAddress(String email);

    @Query(
            value = "SELECT * FROM customers WHERE email_address = ?1",
            nativeQuery = true
    )
    Customer getCustomerByEmailAddressNative(String email);

    @Query(
            value = "SELECT * FROM customers WHERE email_address = :emailAddress",
            nativeQuery = true
    )
    Customer getCustomerByEmailAddressNativeParam(@Param("emailAddress") String email);

    @Transactional
    @Modifying
    @Query(
            value = "UPDATE customers SET first_name = :firstName WHERE email_address = :emailAddress",
            nativeQuery = true
    )
    void updateCustomeFirstNameByEmailAddress(@Param("firstName") String firstName, @Param("emailAddress") String emailAddress);

    int countCustomerByAddress_City(String addressCity);

    @Query(
            value = "SELECT COUNT(*), customer_city FROM customers GROUP BY customer_city",
            nativeQuery = true
    )
    List<Object[]> getCustomerByAddress_CityNative();


}
