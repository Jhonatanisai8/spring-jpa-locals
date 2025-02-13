package com.jhonatan.springdatajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManagerRepositoryTest {
    @Autowired
    private ManagerRepository managerRepository;

    @Test
    void testFindAllManagers() {
        managerRepository.findAll().forEach(System.out::println);
    }
}