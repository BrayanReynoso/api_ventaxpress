package com.mx.ventaXpress.model.sale;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mx.ventaXpress.model.product.Product;
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
@Table(name = "sale_datails")
public class SaleDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private int cantidadProductos;

    @Column(nullable = false)
    private double precioUnitario;

    @Column(nullable = false, length = 4)
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_sale", nullable = false)
    @JsonIgnore
    private Sale sale;
}
