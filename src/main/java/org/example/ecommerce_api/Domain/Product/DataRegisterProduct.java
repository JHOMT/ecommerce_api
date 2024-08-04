package org.example.ecommerce_api.Domain.Product;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DataRegisterProduct(
        @NotNull String name,
        @NotNull Long typeProductId,
        @NotNull BigDecimal price,
        @NotNull Integer rating,
        @NotNull String image,
        @NotNull String description,
        @NotNull Integer quantity
) {
}
