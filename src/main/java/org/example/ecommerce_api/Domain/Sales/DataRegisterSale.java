package org.example.ecommerce_api.Domain.Sales;

import jakarta.validation.constraints.NotNull;
import org.example.ecommerce_api.Domain.SaleItem.DataRegisterSaleItem;

import java.util.List;

public record DataRegisterSale(
        @NotNull Long userId,
        @NotNull List<DataRegisterSaleItem> saleItems
) {
}
