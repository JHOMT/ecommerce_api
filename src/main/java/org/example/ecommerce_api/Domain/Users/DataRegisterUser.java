package org.example.ecommerce_api.Domain.Users;

import jakarta.validation.constraints.NotNull;

public record DataRegisterUser(
        @NotNull String name,
        @NotNull String email,
        @NotNull String password
) {
}
