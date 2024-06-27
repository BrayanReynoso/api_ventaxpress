package com.mx.ventaXpress.controller.supplier;

import com.mx.ventaXpress.model.supplier.Supplier;
import com.mx.ventaXpress.service.supplier.SupplierService;
import com.mx.ventaXpress.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("${API-URL}/supplier")
@CrossOrigin("*")
public class SupplierController {
    @Autowired
    private SupplierService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Supplier>>> getAll(){
        return new ResponseEntity<>(
                service.getAll(), HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<Response<Supplier>> insert(@RequestBody Supplier supplier){
        return new ResponseEntity<>(
                service.insert(supplier), HttpStatus.OK
        );
    }
}
