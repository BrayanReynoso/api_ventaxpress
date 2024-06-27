package com.mx.ventaXpress.service.sale;

import com.mx.ventaXpress.model.sale.Sale;
import com.mx.ventaXpress.repository.sale.SaleRepository;
import com.mx.ventaXpress.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleRepository repository;

    @Transactional(readOnly = true)
    public Response<List<Sale>> getAll(){
        List<Sale> exist = repository.findAll();
        if (!exist.isEmpty()){
            return new Response<>(
                    repository.findAll(),
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                false,
                200,
                "List sales is empty"
        );
    }
}
