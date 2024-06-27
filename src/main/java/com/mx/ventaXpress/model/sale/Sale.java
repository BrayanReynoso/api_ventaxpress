package com.mx.ventaXpress.model.sale;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private Date fechaVenta;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false, length = 4)
    private Boolean status;


}
