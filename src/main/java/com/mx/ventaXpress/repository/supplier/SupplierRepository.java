package com.mx.ventaXpress.repository.supplier;

import com.mx.ventaXpress.model.supplier.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Override
    Optional<Supplier> findById(Long id);

    Optional<Supplier> findByNombre(String nombre);

}
