package org.example.ecommerce_api.Domain.Users;

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
            user.getUsername(),
            user.getEmail()
        );
    }
}
