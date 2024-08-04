package org.example.ecommerce_api.Domain.Product.Validations;

import org.example.ecommerce_api.Domain.Product.DataRegisterProduct;
import org.example.ecommerce_api.Domain.Product.DataUpdateProduct;
import org.example.ecommerce_api.Domain.Product.Product;
import org.example.ecommerce_api.Domain.Product.ProductRepository;
import org.example.ecommerce_api.Domain.TypeProduct.TypeProduct;
import org.example.ecommerce_api.Domain.TypeProduct.TypeProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidTypeProduct implements ValidProducts {

    @Autowired
    private TypeProductRepository typeProductRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void validateRegister(DataRegisterProduct data) {
        Optional<TypeProduct> typeProduct = Optional.ofNullable(typeProductRepository.findById(data.typeProductId())
                .orElseThrow(() -> new RuntimeException("Type product not found")));
    }

    @Override
    public void validateUpdate(DataUpdateProduct data) {
        Optional<Product> typeProduct = Optional.ofNullable(productRepository.findById(data.productId())
                .orElseThrow(() -> new RuntimeException("Type product not found")));
    }
}
