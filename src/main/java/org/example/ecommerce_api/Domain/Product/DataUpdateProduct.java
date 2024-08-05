package org.example.ecommerce_api.Domain.Product;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DataUpdateProduct(
        @NotNull Long id,
        String name,
        Long typeProductId,
        Double price,
        Integer rating,
        String image,
        String description,
        Integer quantity
){
}
