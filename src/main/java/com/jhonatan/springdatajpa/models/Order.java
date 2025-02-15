package com.jhonatan.springdatajpa.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "orders "
)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Size(max = 45)
    @Column(nullable = false)
    private String orderDescription;

    @Column(nullable = false)
    private Double orderPrice;

    //relacion de muchos a uno
    //muchas ordenes pertenecen a un local
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "local_id",
            referencedColumnName = "localId"
    )
    private Local local;

}
