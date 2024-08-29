package com.mx.ventaXpress.model.sale;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

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

    // Si prefieres mantener solo los IDs
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SaleDetails> saleDetails;
}
