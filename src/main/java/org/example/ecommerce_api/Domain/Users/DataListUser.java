package org.example.ecommerce_api.Domain.Users;

public record DataListUser(
        Long id,
        String name,
        String email
) {
    public DataListUser(User data){
        this(
                data.getUserId(),
                data.getName(),
                data.getEmail()
        );
    }
}
