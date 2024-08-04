package org.example.ecommerce_api.Domain.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email = ?1")
    boolean existsByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2")
    Optional<User> validLogin(String email, String password);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findByEmail(String email);
}
