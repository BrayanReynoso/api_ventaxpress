package com.mx.ventaXpress.controller.sale;

import com.mx.ventaXpress.model.sale.SaleDetails;
import com.mx.ventaXpress.service.sale.SaleDatailsService;
import com.mx.ventaXpress.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("${API-URL}/saleDetails")
@CrossOrigin("*")
public class SaleDatailsController {
    @Autowired
    SaleDatailsService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<SaleDetails>>> getAll(){
        return new ResponseEntity<>(
                service.getAll(), HttpStatus.OK
        );
    }
}
