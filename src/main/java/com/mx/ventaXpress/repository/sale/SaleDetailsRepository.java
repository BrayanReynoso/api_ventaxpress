package com.mx.ventaXpress.repository.sale;

import com.mx.ventaXpress.model.sale.SaleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaleDetailsRepository extends JpaRepository<SaleDetails, Long> {
    @Override
    Optional<SaleDetails> findById(Long id);


}
