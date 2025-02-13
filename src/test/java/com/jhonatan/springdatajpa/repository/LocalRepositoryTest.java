package com.jhonatan.springdatajpa.repository;

import com.jhonatan.springdatajpa.models.Local;
import com.jhonatan.springdatajpa.models.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}