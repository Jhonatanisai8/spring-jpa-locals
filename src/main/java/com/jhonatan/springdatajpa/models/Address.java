package com.jhonatan.springdatajpa.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable //esta la se podra encustrar dentro de otra clase
@AttributeOverrides(
        {
                @AttributeOverride(
                        name = "city",
                        column = @Column(name = "customer_city", length = 45, nullable = false)
                ),
                @AttributeOverride(
                        name = "mainStreet",
                        column = @Column(name = "customer_main_street", length = 50)
                ),
                @AttributeOverride(
                        name = "secondaryStreet",
                        column = @Column(name = "customer_secondary_street", length = 50)
                )
        }
)
public class Address {

    @Column(length = 45, nullable = false)
    //@NotEmpty
    private String city;

    @Column(length = 50)
    @NotEmpty(message = "Por favor se necesita una calle principal")
    private String mainStreet;

    @Column(length = 50)
    @NotEmpty
    private String secondaryStreet;
}
