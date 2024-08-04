package org.example.ecommerce_api.Domain.Sales;

import org.example.ecommerce_api.Domain.SaleItem.DataListSaleItem;

import java.math.BigDecimal;
import java.util.List;

public record DataListSale(
        String userName,
        String userEmail,
        String saleDate,
        BigDecimal totalPrice,
        List<DataListSaleItem> saleItems
) {
    public DataListSale(Sale data) {
        this(
                data.getUser().getUsername(),
                data.getUser().getEmail(),
                data.getSaleDate().toString(),
                data.getTotalPrice(),
                data.getSaleItems().stream().map(DataListSaleItem::new).toList()
        );
    }
}
