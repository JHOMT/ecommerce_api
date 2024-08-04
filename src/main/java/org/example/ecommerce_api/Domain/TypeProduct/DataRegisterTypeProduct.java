package org.example.ecommerce_api.Domain.TypeProduct;

import jakarta.validation.constraints.NotNull;

public record DataRegisterTypeProduct(
        @NotNull String name,
        @NotNull String description
) {
}
