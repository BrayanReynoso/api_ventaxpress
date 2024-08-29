package com.mx.ventaXpress.service.sale;

import com.mx.ventaXpress.model.sale.SaleDetails;
import com.mx.ventaXpress.repository.sale.SaleDetailsRepository;
import com.mx.ventaXpress.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class SaleDatailsService {

    @Autowired
    private SaleDetailsRepository repository;

    @Transactional(readOnly = true)
    public Response<List<SaleDetails>> getAll(){
        List<SaleDetails> exist = this.repository.findAll();
        if(!exist.isEmpty()){
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
                "Data Sale Datails is empty"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<SaleDetails> insert(SaleDetails details){
        return new Response<>(
                this.repository.save(details),
                false,
                200,
                "Data Sale Datails inserted"
        );
    }

}
