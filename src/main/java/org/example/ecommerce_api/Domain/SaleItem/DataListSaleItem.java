package org.example.ecommerce_api.Domain.SaleItem;

public record DataListSaleItem(
        Long saleId,
        String productName,
        Integer quantity,
        String price
) {
    public DataListSaleItem(SaleItem data){
        this(
                data.getId(),
                data.getProduct().getName(),
                data.getQuantity(),
                data.getPrice().toString()
        );
    }
}
