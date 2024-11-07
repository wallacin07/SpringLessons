package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Ex9;
import com.example.demo.dto.Token;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.JWTService;

@RestController
public class exercicio9 {
    
    @Autowired
    UserRepository repo;

     @Autowired
    PasswordEncoder encoder;

    @Autowired
    JWTService<Token> jwtService;


@PostMapping("/login")
    public ResponseEntity<String> create(@RequestBody Ex9 loginData) {

        if (loginData.username() == null || loginData.password() == null) {
            return new ResponseEntity<>(
                "login and password are expected.", 
                HttpStatus.BAD_REQUEST
            );
        }
        var users = repo.login(loginData.username());

        if (users.isEmpty()) {
            return new ResponseEntity<>(
                "The user do not exists.", 
                HttpStatus.UNAUTHORIZED
            );
        }
        var user = users.get(0);

        if (!encoder.matches(loginData.password(), user.getPassword())) {
            return new ResponseEntity<>(
                "The password is incorrect.", 
                HttpStatus.UNAUTHORIZED
            );
        }

        Token token = new Token();
        token.setId(user.getId());
        
        var jwt = jwtService.get(token);

        return new ResponseEntity<>(
            jwt,
            HttpStatus.OK
        );
    }
}
