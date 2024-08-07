package org.example.ecommerce_api.Infra.Security;

import org.example.ecommerce_api.Domain.Users.User;

public record DataResponseLogin(
    String token,
    Long id,
    String username,
    String email
) {
    public DataResponseLogin(User user, String token){
        this(
            token,
            user.getUserId(),
            user.getName(),
            user.getEmail()
        );
    }
}
