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
    private T data;
    private Boolean error;
    private int status;
    private String message;
}
