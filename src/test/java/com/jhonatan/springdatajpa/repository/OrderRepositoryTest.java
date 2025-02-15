package com.jhonatan.springdatajpa.repository;

import com.jhonatan.springdatajpa.models.Local;
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
    void testSaveOrder() {
        Local local = Local.builder()
                .localName("Local Name 01")
                .localFloor("Local Floor 01")
                .build();

        Order order = Order.builder()
                .orderDescription("1 leche")
                .orderPrice(3.2)
                .local(local)
                .build();
        repository.save(order);
    }

    @Test
    void testFindAllOrders() {
        repository.findAll().forEach(System.out::println);
    }

}