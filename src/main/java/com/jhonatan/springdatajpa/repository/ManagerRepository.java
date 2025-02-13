package com.jhonatan.springdatajpa.repository;

import com.jhonatan.springdatajpa.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository
        extends JpaRepository<Manager, Long> {
}
