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
@Table(uniqueConstraints = @UniqueConstraint(
        name = "local_name_unique",
        columnNames = "local_name"
))
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long localId;

    @NotEmpty
    @Size(max = 50)
    @Column(nullable = false, unique = true)
    private String localName;

    @NotEmpty
    @Column(nullable = false)
    @Size(max = 50)
    private String localFloor;

    @OneToOne
    @JoinColumn(
            name = "manager_id",
            referencedColumnName = "managerId"
    )
    private Manager manager;

}
