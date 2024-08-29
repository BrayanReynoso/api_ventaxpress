package com.mx.ventaXpress.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response <T>{
    private T data; // Object
    private Boolean error; // False
    private int status; // 200
    private String message; // OK
}
