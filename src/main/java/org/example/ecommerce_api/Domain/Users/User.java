package org.example.ecommerce_api.Domain.Users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@EqualsAndHashCode(of = "userId")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", nullable = false)
    private String name;

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
        this.name = dataRegisterUser.name();
        this.password = dataRegisterUser.password();
        this.email = dataRegisterUser.email();
    }

    public void update(DataUpdateUser dataUpdateUser){
        if (dataUpdateUser.id() == null) throw new RuntimeException("Id is required");
        if (dataUpdateUser.name() != null) this.name = dataUpdateUser.name();
        if (dataUpdateUser.password() != null) this.password = dataUpdateUser.password();
        if (dataUpdateUser.email() != null) this.email = dataUpdateUser.email();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE-USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
