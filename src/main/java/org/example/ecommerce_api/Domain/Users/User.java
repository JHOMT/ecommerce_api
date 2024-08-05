package org.example.ecommerce_api.Domain.Users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.security.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "created_at", nullable = false, updatable = false, insertable = false)
    @Generated(GenerationTime.INSERT)
    private LocalDateTime createdAt;

    public User(Long userId) {
        this.userId = userId;
    }

    public User(DataRegisterUser dataRegisterUser){
        this.username = dataRegisterUser.name();
        this.password = dataRegisterUser.password();
        this.email = dataRegisterUser.email();
    }

    public void update(DataUpdateUser dataUpdateUser){
        if (dataUpdateUser.id() == null) throw new RuntimeException("Id is required");
        if (dataUpdateUser.name() != null) this.username = dataUpdateUser.name();
        if (dataUpdateUser.password() != null) this.password = dataUpdateUser.password();
        if (dataUpdateUser.email() != null) this.email = dataUpdateUser.email();
    }
}
