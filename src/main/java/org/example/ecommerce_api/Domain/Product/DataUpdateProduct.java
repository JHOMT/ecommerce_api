package org.example.ecommerce_api.Domain.Product;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DataUpdateProduct(
        @NotNull Long productId,
        String name,
        Long productType,
        BigDecimal price,
        Integer rating,
        String image,
        String description,
        Integer quantity
){
}
