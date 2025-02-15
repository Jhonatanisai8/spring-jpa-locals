package com.jhonatan.springdatajpa.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "local_name_unique",
                columnNames = "local_name"
        ))
@ToString(
        exclude = "manager"
)
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

    @OneToOne(
            //se guardara un local y a la ves el manager
            cascade = CascadeType.PERSIST,
            //se cargan los datos del manager con la entidad
            fetch = FetchType.EAGER
            //fetch = FetchType.LAZY
            //optional = false //fuerza a guardar un manager
    )
    @JoinColumn(
            name = "manager_id",
            referencedColumnName = "managerId"
    )
    private Manager manager;

//    @OneToMany(
//            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER //trae las ordenes de cada local
//    )
//    @JoinColumn(
//            name = "local_id",
//            referencedColumnName = "localId"
//    )
//    private List<Order> orders;

}
