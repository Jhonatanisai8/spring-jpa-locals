package com.jhonatan.springdatajpa.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "customers",
        uniqueConstraints = @UniqueConstraint(
                name = "email_unique",
                columnNames = "email_address"
        )
)
@Builder
public class Customer {

    @Id
//    @SequenceGenerator(
//            //el email sera unico
//            name = "customers_sequence",
//            sequenceName = "customers_sequence",
//            allocationSize = 1
//    )
    @GeneratedValue(
            //generator = "customers_sequence",
            strategy = GenerationType.IDENTITY
    )
    private Long customerId;

    @Size(max = 50)
    //@NotBlank
    private String firstName;

    @NotEmpty
    @Size(max = 50)
    private String lastName;

    @NotEmpty
    @Size(max = 50)
    @Column(
            name = "email_address",
            nullable = false
    )
    private String email;

    //    private String customerCity;
//    private String customerMainStreet;
//    private String customerSecondaryStreet;
    @Embedded
    @Valid
    private Address address;
}
