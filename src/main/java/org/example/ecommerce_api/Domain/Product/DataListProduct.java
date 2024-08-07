package org.example.ecommerce_api.Domain.Product;

public record DataListProduct(
        Long id,
        String name,
        String productType,
        Long typeId,
        Double price,
        int rating,
        String image,
        String description,
        int stock
) {
    public DataListProduct(Product product) {
        this(
                product.getProductId(),
                product.getName(),
                product.getTypeProduct().getName(),
                product.getTypeProduct().getTypeId(),
                product.getPrice(),
                product.getRating(),
                product.getImage(),
                product.getDescription(),
                product.getQuantity()
        );
    }
}