package org.example.ecommerce_api.Domain.TypeProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeProductRepository extends JpaRepository<TypeProduct, Long> {
    @Query("SELECT t FROM TypeProduct t WHERE t.name = ?1")
    Optional<TypeProduct> findByName(String name);
}
