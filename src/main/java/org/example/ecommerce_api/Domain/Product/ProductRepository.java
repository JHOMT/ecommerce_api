package org.example.ecommerce_api.Domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.typeProduct.typeId = ?1")
    List<Product> findByTypeProductId(Long id);

    @Query("""
            SELECT p
            FROM Product p
            WHERE p.name LIKE %?1%
            OR p.description LIKE %?1%
    """)
    List<Product> findByName(String name);
}
