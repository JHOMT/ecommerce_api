package org.example.ecommerce_api.Domain.Users.Validations;

import org.example.ecommerce_api.Domain.Users.DataRegisterUser;
import org.example.ecommerce_api.Domain.Users.DataUpdateUser;
import org.example.ecommerce_api.Domain.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidEmailExist implements ValidUser{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void validateRegister(DataRegisterUser dataRegisterUser) {
        if(userRepository.existsByEmail(dataRegisterUser.email())){
            throw new RuntimeException("Email already exists");
        }
    }

    @Override
    public void validUpdate(DataUpdateUser dataUpdateUser) {

    }
}
