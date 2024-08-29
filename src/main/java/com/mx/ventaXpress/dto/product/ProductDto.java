package com.mx.ventaXpress.dto.product;


import com.mx.ventaXpress.model.brand.Brand;
import com.mx.ventaXpress.model.category.Category;
import com.mx.ventaXpress.model.product.Product;
import com.mx.ventaXpress.model.supplier.Supplier;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private long id;
    private String nombre;
    private String descripcion;
    private double precioCompra;
    private double precioVenta;
    private int stock;
    private Date fechaCaducidad;
    private Date fechaCompra;
    private Category category;
    private Brand brand;
    private Boolean status;
    private Supplier supplier;
    public Product getProduct(){

        return new Product(
                getId(),
                getNombre(),
                getDescripcion(),
                getPrecioCompra(),
                getPrecioVenta(),
                getStock(),
                getFechaCaducidad(),
                getFechaCompra(),
                getStatus(),
                getCategory(),
                getBrand(),
                getSupplier()
        );
    }
}
