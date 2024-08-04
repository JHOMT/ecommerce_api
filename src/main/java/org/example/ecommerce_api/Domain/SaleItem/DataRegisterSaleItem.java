package org.example.ecommerce_api.Domain.SaleItem;

import jakarta.validation.constraints.NotNull;

public record DataRegisterSaleItem(
    @NotNull Long productId,
    @NotNull Integer quantity
) {
}
