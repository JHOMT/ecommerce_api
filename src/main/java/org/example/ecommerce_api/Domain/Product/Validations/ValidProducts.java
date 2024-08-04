package org.example.ecommerce_api.Domain.Product.Validations;

import org.example.ecommerce_api.Domain.Product.DataRegisterProduct;
import org.example.ecommerce_api.Domain.Product.DataUpdateProduct;

public interface ValidProducts {
    void validateRegister(DataRegisterProduct data);
    void validateUpdate(DataUpdateProduct data);
}
