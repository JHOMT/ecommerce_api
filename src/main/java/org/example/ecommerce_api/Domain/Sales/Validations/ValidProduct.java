package org.example.ecommerce_api.Domain.Sales.Validations;

import org.example.ecommerce_api.Domain.Product.Product;
import org.example.ecommerce_api.Domain.Product.ProductRepository;
import org.example.ecommerce_api.Domain.Sales.DataRegisterSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidProduct implements ValidSale {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void validateRegister(DataRegisterSale data) {
        data.saleItems().forEach(saleItem -> {
            Product product = productRepository.findById(saleItem.productId())
                    .orElseThrow(() -> new IllegalArgumentException("Product not found"));
            if (product.getQuantity() < saleItem.quantity()) {
                throw new IllegalArgumentException("Product out of stock");
            }
        });
    }
}