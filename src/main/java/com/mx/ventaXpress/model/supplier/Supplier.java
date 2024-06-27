package com.mx.ventaXpress.model.supplier;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(nullable = false, length = 10)
    private String telefono;

    @Column(nullable = false, length = 4)
    private Boolean status;


}
