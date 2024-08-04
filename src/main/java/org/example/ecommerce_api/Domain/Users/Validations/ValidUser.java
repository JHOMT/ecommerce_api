package org.example.ecommerce_api.Domain.Users.Validations;

import org.example.ecommerce_api.Domain.Users.DataRegisterUser;
import org.example.ecommerce_api.Domain.Users.DataUpdateUser;

public interface ValidUser {
    void validateRegister(DataRegisterUser dataRegisterUser);
    void validUpdate(DataUpdateUser dataUpdateUser);
}
