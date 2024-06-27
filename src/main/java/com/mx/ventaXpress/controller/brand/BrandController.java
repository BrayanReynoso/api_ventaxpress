package com.mx.ventaXpress.controller.brand;

import com.mx.ventaXpress.controller.brand.dto.BrandDto;
import com.mx.ventaXpress.model.brand.Brand;
import com.mx.ventaXpress.service.brand.BrandService;
import com.mx.ventaXpress.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("${API-URL}")
@CrossOrigin("*")
public class BrandController {
    @Autowired
    private BrandService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Brand>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(), HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<Response<Brand>> insert(@RequestBody Brand brand){
        return new ResponseEntity<>(
                this.service.insert(brand), HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Response<Brand>> update(@RequestBody BrandDto brandDto){
        return new ResponseEntity<>(
                    this.service.update(brandDto.getBrand()), HttpStatus.OK
                );
    }

    @DeleteMapping("/status/{id}")
    public ResponseEntity<Response<Brand>> changeStatus(@PathVariable("id") long id){
        return new ResponseEntity<>(
                this.service.changeStatus(id), HttpStatus.OK
        );
    }
}
