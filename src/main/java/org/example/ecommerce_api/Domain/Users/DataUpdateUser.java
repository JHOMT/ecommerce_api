package org.example.ecommerce_api.Domain.Users;

import jakarta.validation.constraints.NotNull;

public record DataUpdateUser(
        @NotNull Long id,
        String name,
        String email,
        String password
) {
}
