package org.example.ecommerce_api.Domain.TypeProduct;

import jakarta.validation.constraints.NotNull;

public record DataUpdateTypeProduct(
        @NotNull Long id,
        String name
) {
}
