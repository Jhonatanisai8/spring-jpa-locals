package com.jhonatan.springdatajpa.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;

    @Column(nullable = false)
    @NotEmpty
    @Size(max = 50)
    private String firstNameManager;

    @Column(nullable = false)
    @NotEmpty
    @Size(max = 50)
    private String lastNameManager;
}
