package com.jhonatan.springdatajpa.repository;

import com.jhonatan.springdatajpa.models.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepositoryTest {
    @Autowired
    private OrderRepository repository;

    @Test
    void testFindAllOrders() {
        repository.findAll().forEach(System.out::println);
    }

}