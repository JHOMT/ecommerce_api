package org.example.ecommerce_api.Domain.Sales.Validations;

import org.example.ecommerce_api.Domain.Sales.DataRegisterSale;
import org.example.ecommerce_api.Domain.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidUser implements ValidSale {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void validateRegister(DataRegisterSale data) {
        if (!userRepository.existsById(data.userId())) {
            throw new IllegalArgumentException("User not found");
        }
    }
}