package com.jhonatan.springdatajpa.repository;

import com.jhonatan.springdatajpa.models.Local;
import com.jhonatan.springdatajpa.models.Manager;
import com.jhonatan.springdatajpa.models.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LocalRepositoryTest {

    @Autowired
    private LocalRepository repository;

    @Test
    void testSaveLocal() {

        Manager manager = Manager.builder()
                .firstNameManager("Manager 01")
                .lastNameManager("Manager 01 Last Name")
                .build();

        Local local = Local.builder()
                .localName("test")
                .localFloor("Floor 1")
                .manager(manager)
                .build();
        repository.save(local);
    }

    @Test
    void testFindAllLocals() {
        repository.findAll().forEach(System.out::println);
    }

    @Test
    void testSaveLocalWithOrders() {
        Manager manager = Manager.builder()
                .firstNameManager("Manager 01")
                .lastNameManager("Manager 01 Last Name")
                .build();

        Order order01 = Order.builder()
                .orderDescription("1kg de Pollo")
                .orderPrice(10.5)
                .build();
        Order order02 = Order.builder()
                .orderDescription("4 unidades de Café")
                .orderPrice(5.50)
                .build();


        Local local = Local.builder()
                .localName("Tienda Juanito")
                .localFloor("Piso 6")
                .manager(manager)
                .orders(List.of(order01, order02))
                .build();

        repository.save(local);
    }

    @Test
    void testFindAllLocalsWithOrders() {
        repository.findAll().forEach(System.out::println);
    }

    @Test
    void testFindAllOrdersByLocalId() {
    }
}