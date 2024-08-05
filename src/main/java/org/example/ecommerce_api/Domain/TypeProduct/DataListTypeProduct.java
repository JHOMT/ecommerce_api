package org.example.ecommerce_api.Domain.TypeProduct;

public record DataListTypeProduct(
        Long id,
        String name
) {
    public DataListTypeProduct(TypeProduct data){
        this(
                data.getTypeId(),
                data.getName()
        );
    }
}
