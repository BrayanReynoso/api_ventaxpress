package com.mx.ventaXpress.service.supplier;

import com.mx.ventaXpress.model.supplier.Supplier;
import com.mx.ventaXpress.repository.supplier.SupplierRepository;
import com.mx.ventaXpress.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository repository;

    @Transactional(readOnly = true)
    public Response<List<Supplier>> getAll(){
        List<Supplier> exist = repository.findAll();
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
                "The list supplier is empty"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Supplier> insert(Supplier supplier){
        Optional<Supplier> exist = repository.findByNombre(supplier.getNombre());
        if (!exist.isPresent()){
            return new Response<>(
                    repository.save(supplier),
                    false,
                    200,
                    "Saved Register"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "Error in save register"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Supplier> changeStatus(long id){
        Optional<Supplier> exist = repository.findById(id);
       if (exist.isPresent()){
           exist.get().setStatus(!exist.get().getStatus());
           return new Response<>(
                   this.repository.saveAndFlush(exist.get()),
                   false,
                   200,
                   "Changed status of register to " + exist.get().getNombre()
           );
       }
       return new Response<>(
               null,
               true,
               400,
               "Error in change status"
       );
    }
}
