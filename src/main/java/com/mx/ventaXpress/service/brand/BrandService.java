package com.mx.ventaXpress.service.brand;

import com.mx.ventaXpress.model.brand.Brand;
import com.mx.ventaXpress.repository.brand.BrandRepository;
import com.mx.ventaXpress.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    @Autowired
    private BrandRepository repository;

    //METHOD GET
    @Transactional(readOnly = true)
    public Response<List<Brand>> getAll(){
        List<Brand> brandList = this.repository.findAll();
        if (!brandList.isEmpty()){
            return new Response<>(
                    this.repository.findAll(),
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                200,
                "Table Brand is empty"
        );
    }

    //METHOD INSERT
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Brand> insert(Brand brand){
        Optional<Brand> existBrand = this.repository.findByNombre(brand.getNombre());
        if (!existBrand.isPresent()){
            return new Response<>(
                    this.repository.save(brand),
                    false,
                    200,
                    "Save is OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "Error in Save Brand"
        );
    }

    //METHOS UPDATE
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Brand> update(Brand brand){
        Optional<Brand> existBrand = this.repository.findById(brand.getId());
        if (existBrand.isPresent()){
            return new Response<>(
                    this.repository.saveAndFlush(brand),
                    false,
                    200,
                    "Successful update Brand"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "Unsuccessful update Brand"
        );

    }

    //METHOD CHANGE STATUS
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Brand> changeStatus(long id){
        Optional<Brand> existBrand = this.repository.findById(id);
        if (existBrand.isPresent()){
            existBrand.get().setStatus(!existBrand.get().getStatus());
            return new Response<>(
                    this.repository.saveAndFlush(existBrand.get()),
                    false,
                    200,
                    "Successful change status"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "Unsuccessful change status"
        );
    }

}
