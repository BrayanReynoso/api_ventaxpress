package com.mx.ventaXpress.controller.brand.dto;

import com.mx.ventaXpress.model.brand.Brand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BrandDto {
    private long id;
    private String nombre;
    private Boolean status;

    public Brand getBrand(){
        return new Brand(
                getId(),
                getNombre(),
                getStatus()
        );
    }
}
