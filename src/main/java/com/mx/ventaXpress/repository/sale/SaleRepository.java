package com.mx.ventaXpress.repository.sale;

import com.mx.ventaXpress.model.sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    @Override
    Optional<Sale> findById(Long aLong);

}
