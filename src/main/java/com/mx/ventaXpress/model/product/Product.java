package com.mx.ventaXpress.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mx.ventaXpress.model.brand.Brand;
import com.mx.ventaXpress.model.category.Category;
import com.mx.ventaXpress.model.supplier.Supplier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(nullable = false, length = 250)
    private String descripcion;

    @Column(nullable = false, length = 10)
    private double precioCompra;

    @Column(nullable = false, length = 10)
    private double precioVenta;

    @Column(nullable = false, length = 10)
    private int stock;

    @Column(nullable = false, length = 15)
    private Date fechaCaducidad;

    @Column(nullable = false, length = 10)
    private Date fechaCompra;

    @Column(nullable = false, length = 4)
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "id_supplier")
    private Supplier supplier;




}
