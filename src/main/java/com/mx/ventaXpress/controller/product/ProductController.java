package com.mx.ventaXpress.controller.product;


import com.mx.ventaXpress.controller.product.dto.ProductDto;
import com.mx.ventaXpress.model.product.Product;
import com.mx.ventaXpress.service.product.ProductService;
import com.mx.ventaXpress.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("${API-URL}/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Product>>> getAllProducts() {
        Response<List<Product>> response = service.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Response<Product>> insert(@RequestBody Product product){
        return new ResponseEntity<>(
                this.service.insert(product), HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Response<Product>> update(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(
                this.service.update(productDto.getProduct()), HttpStatus.OK
        );
    }

    @DeleteMapping("/status/{id}")
    public ResponseEntity<Response<Product>> changeStatus(@PathVariable("id") long id){
        return new ResponseEntity<>(
                this.service.changeStatus(id), HttpStatus.OK
        );
    }
}
