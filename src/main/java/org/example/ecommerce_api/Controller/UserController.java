package org.example.ecommerce_api.Controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.example.ecommerce_api.Infra.Security.DataLoginUser;
import org.example.ecommerce_api.Domain.Users.DataRegisterUser;
import org.example.ecommerce_api.Domain.Users.DataUpdateUser;
import org.example.ecommerce_api.Domain.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid DataRegisterUser data){
        return new ResponseEntity<>(userService.save(data), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid DataUpdateUser data){
        return new ResponseEntity<>(userService.update(data), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid DataLoginUser data){
        return new ResponseEntity<>(userService.login(data), HttpStatus.OK);
    }
}
