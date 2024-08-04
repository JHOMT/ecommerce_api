package org.example.ecommerce_api.Domain.Users;

import jakarta.validation.constraints.NotNull;

public record DataLoginUser(
    @NotNull String email,
    @NotNull String password
) {
}
