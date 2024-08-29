package com.mx.ventaXpress.controller.category;

import com.mx.ventaXpress.dto.category.CategoryDto;
import com.mx.ventaXpress.model.category.Category;
import com.mx.ventaXpress.service.category.CategoryService;
import com.mx.ventaXpress.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("${API-URL}/category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryService service;
    @GetMapping("/")
    public ResponseEntity<Response<List<Category>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(), HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<Response<Category>> insert(@RequestBody Category category){
        return new ResponseEntity<>(
                this.service.insert(category), HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Response<Category>> update(@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(
                this.service.update(categoryDto.getCategory()), HttpStatus.OK
        );
    }

    @DeleteMapping("/status/{id}")
    public ResponseEntity<Response<Category>> changeStatus(@PathVariable("id") long id){
        return new ResponseEntity<>(
                this.service.changeStatus(id), HttpStatus.OK
        );
    }
}
