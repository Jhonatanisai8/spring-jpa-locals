package com.jhonatan.springdatajpa.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
                        column = @Column( name = "customer_city")
                ),
                @AttributeOverride(
                        name = "mainStreet",
                        column = @Column(name = "customer_main_street")
                ),
                @AttributeOverride(
                        name = "secondaryStreet",
                        column = @Column(name = "customer_secondary_street")
                )
        }
)
public class Address {
    private String city;
    private String mainStreet;
    private String secondaryStreet;
}
