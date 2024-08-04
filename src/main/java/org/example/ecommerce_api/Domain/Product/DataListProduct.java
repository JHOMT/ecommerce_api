package org.example.ecommerce_api.Domain.Product;

public record DataListProduct(
        Long productId,
        String name,
        String productType,
        String price,
        int rating,
        String image,
        String description,
        int quantity
) {
    public DataListProduct(Product product) {
        this(
                product.getProductId(),
                product.getName(),
                product.getTypeProduct().getName(),
                product.getPrice().toString(),
                product.getRating(),
                product.getImage(),
                product.getDescription(),
                product.getQuantity()
        );
    }
}
