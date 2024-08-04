package org.example.ecommerce_api.Domain.Product.Validations;

import org.example.ecommerce_api.Domain.Product.DataRegisterProduct;
import org.example.ecommerce_api.Domain.Product.DataUpdateProduct;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class ValidData implements ValidProducts{

    @Override
    public void validateRegister(@NotNull DataRegisterProduct data) {
        if(data.name().length() < 3){
            throw new RuntimeException("Name must have at least 3 characters");
        }
        if(data.description().length() < 3){
            throw new RuntimeException("Description must have at least 3 characters");
        }
    }

    @Override
    public void validateUpdate(DataUpdateProduct data) {
        if(data.name().length() < 3){
            throw new RuntimeException("Name must have at least 3 characters");
        }
        if(data.description().length() < 3){
            throw new RuntimeException("Description must have at least 3 characters");
        }
    }
}
