package com.mx.ventaXpress.service.product;

import com.mx.ventaXpress.model.category.Category;
import com.mx.ventaXpress.model.product.Product;
import com.mx.ventaXpress.repository.product.ProductRepository;
import com.mx.ventaXpress.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public Response<List<Product>> getAll(){
        List<Product> categoryList = this.repository.findAll();
        if (!categoryList.isEmpty()){
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
                "Table product is Empty"
        );
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Product> insert(Product product){
        Optional<Product> exist = this.repository.findByNombre(product.getNombre());
        if (!exist.isPresent()){
            return new Response<>(
                    this.repository.save(product),
                    false,
                    200,
                    "Successful save Product"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "Unsuccessful save Product"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Product> update(Product product){
        Optional<Product> existCategory = this.repository.findById(product.getId());
        if (existCategory.isPresent()){
            return new Response<>(
                    this.repository.saveAndFlush(product),
                    false,
                    200,
                    "Successful update Product"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "Unsuccessful update Product"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Product> changeStatus(long id){
        Optional<Product> exist = this.repository.findById(id);
        if (exist.isPresent()){
            exist.get().setStatus(!exist.get().getStatus());
            return new Response<>(
                    this.repository.saveAndFlush(exist.get()),
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
