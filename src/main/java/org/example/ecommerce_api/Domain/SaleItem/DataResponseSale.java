package org.example.ecommerce_api.Domain.SaleItem;

import jakarta.validation.groups.ConvertGroup;
import org.example.ecommerce_api.Domain.Sales.DataListSale;

import java.util.List;

public record DataResponseSale(
        DataListSale sale,
        List<DataListSaleItem> saleItems
) {
}
