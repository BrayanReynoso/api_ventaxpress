package com.mx.ventaXpress.controller.category.dto;

import com.mx.ventaXpress.model.category.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private long id;
    private String nombre;
    private String descripcion;
    private Boolean status;
    public Category getCategory(){
        return new Category(
               getId(),
                getNombre(),
                getDescripcion(),
                getStatus()
        );
    }
}
