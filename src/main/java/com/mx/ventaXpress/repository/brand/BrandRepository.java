package com.mx.ventaXpress.repository.brand;

import com.mx.ventaXpress.model.brand.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Override
    Optional<Brand> findById(Long id);
    Optional<Brand> findByNombre(String nombre);
}
