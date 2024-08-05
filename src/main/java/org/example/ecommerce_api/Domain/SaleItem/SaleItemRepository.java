package org.example.ecommerce_api.Domain.SaleItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {

    @Query("""
            SELECT si
            FROM SaleItem si
            WHERE si.sale.saleId = :saleId
            """)
    List<SaleItem> findBySaleSaleId(Long saleId);
}
