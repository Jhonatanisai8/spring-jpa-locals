package com.jhonatan.springdatajpa.models;

import com.jhonatan.springdatajpa.validation.anotations.EmailRegex;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
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
    private String firstName;

    @NotEmpty
    @Size(max = 50)
    private String lastName;

    @EmailRegex
    @Size(max = 50)
    @Column(
            name = "email_address",
            nullable = false
    )
    private String email;

    @Embedded
    @Valid
    private Address address;

    @NotNull
    @Min(900000000)
    @Max(999999999)
    private Integer phone;
}
