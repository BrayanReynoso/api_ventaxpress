package com.mx.ventaXpress.model.category;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(nullable = false, length = 255)
    private String descripcion;

    @Column(nullable = false, length = 4)
    private Boolean status;
}
