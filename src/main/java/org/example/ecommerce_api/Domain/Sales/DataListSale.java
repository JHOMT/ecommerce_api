package org.example.ecommerce_api.Domain.Sales;

public record DataListSale(
        String userName,
        String userEmail,
        String saleDate,
        Double totalPrice
) {
    public DataListSale(Sale data) {
        this(
                data.getUser().getName(),
                data.getUser().getEmail(),
                data.getSaleDate().toString(),
                data.getTotalPrice()
        );
    }
}
