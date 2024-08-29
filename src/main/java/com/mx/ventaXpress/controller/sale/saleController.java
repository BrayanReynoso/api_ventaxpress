package com.mx.ventaXpress.controller.sale;

import com.mx.ventaXpress.model.sale.Sale;
import com.mx.ventaXpress.service.sale.SaleService;
import com.mx.ventaXpress.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("${API-URL}/sale")
@CrossOrigin("*")
public class saleController {
    @Autowired
    private SaleService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Sale>>> getAll(){
        return new ResponseEntity<>(
                service.getAll(), HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<Response<Sale>> insert(@RequestBody Sale sale){
        return new ResponseEntity<>(
                this.service.insert(sale),HttpStatus.CREATED
        );
    }
}
