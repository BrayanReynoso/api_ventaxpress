package com.mx.ventaXpress.repository.category;

import com.mx.ventaXpress.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Override
    Optional<Category> findById(Long id);

    Optional<Category> findByNombre(String nombre);
}
