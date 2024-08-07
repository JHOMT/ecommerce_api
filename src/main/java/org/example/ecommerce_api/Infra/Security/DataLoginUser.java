package org.example.ecommerce_api.Infra.Security;

import jakarta.validation.constraints.NotNull;

public record DataLoginUser(
    @NotNull String email,
    @NotNull String password
) {
}
