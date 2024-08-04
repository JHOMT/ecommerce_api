package org.example.ecommerce_api.Domain.Sales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    @Query("SELECT s FROM Sale s WHERE s.user.userId = :userId")
    List<Sale> findByUserId(Long userId);
}
