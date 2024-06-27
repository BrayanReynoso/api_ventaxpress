package com.mx.ventaXpress.service.category;

import com.mx.ventaXpress.model.brand.Brand;
import com.mx.ventaXpress.model.category.Category;
import com.mx.ventaXpress.repository.category.CategoryRepository;
import com.mx.ventaXpress.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public Response<List<Category>> getAll(){
        List<Category> categoryList = this.repository.findAll();
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
                "Table category is Empty"
        );
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Category> insert(Category category){
        Optional<Category> existCategory = this.repository.findByNombre(category.getNombre());
        if (!existCategory.isPresent()){
            return new Response<>(
                    this.repository.save(category),
                    false,
                    200,
                    "Successful save category"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "Unsuccessful save category"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Category> update(Category category){
       Optional<Category> existCategory = this.repository.findById(category.getId());
       if (existCategory.isPresent()){
           return new Response<>(
                   this.repository.saveAndFlush(category),
                   false,
                   200,
                   "Successful update category"
           );
       }
       return new Response<>(
               null,
               true,
               400,
               "Unsuccessful update category"
       );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Category> changeStatus(long id){
        Optional<Category> existCategory = this.repository.findById(id);
        if (existCategory.isPresent()){
            existCategory.get().setStatus(!existCategory.get().getStatus());
            return new Response<>(
                    this.repository.saveAndFlush(existCategory.get()),
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
