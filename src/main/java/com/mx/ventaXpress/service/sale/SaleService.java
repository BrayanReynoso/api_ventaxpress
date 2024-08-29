package com.mx.ventaXpress.service.sale;

import com.mx.ventaXpress.model.sale.Sale;
import com.mx.ventaXpress.repository.sale.SaleRepository;
import com.mx.ventaXpress.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Sale> insert(Sale sale){
            return new Response<>(
                    this.repository.save(sale),
                    false,
                    200,
                    "OK"
            );
    }
}
