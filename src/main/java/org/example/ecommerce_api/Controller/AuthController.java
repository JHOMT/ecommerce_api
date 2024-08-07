package org.example.ecommerce_api.Controller;

import jakarta.validation.Valid;
import org.example.ecommerce_api.Domain.Users.DataRegisterUser;
import org.example.ecommerce_api.Domain.Users.User;
import org.example.ecommerce_api.Domain.Users.UserRepository;
import org.example.ecommerce_api.Domain.Users.UserService;
import org.example.ecommerce_api.Infra.Security.DataLoginUser;
import org.example.ecommerce_api.Infra.Security.DataResponseLogin;
import org.example.ecommerce_api.Infra.Security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> auth (@RequestBody @Valid DataLoginUser data){
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(data.email(), data.password());
            var authentication = authenticationManager.authenticate(authenticationToken);
            var user = (User) authentication.getPrincipal();
            var token = tokenService.generateToken(user);
            return new ResponseEntity<>(new DataResponseLogin(user, token), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody @Valid DataRegisterUser data){
        return new ResponseEntity<>(userService.save(data), HttpStatus.CREATED);
    }
}
