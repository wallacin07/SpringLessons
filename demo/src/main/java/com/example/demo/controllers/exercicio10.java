package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.Ex10;
import com.example.demo.dto.Token;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.JWTService;

public class exercicio10 {

    @Autowired
    UserRepository repo;

     @Autowired
    PasswordEncoder encoder;

    @Autowired
    JWTService<Token> jwtService;


    @PostMapping("/login")
    public ResponseEntity<String> createProduct(@RequestBody Ex10 inf) {


        var jwt = jwtService.get(inf.token());
        var valide = jwtService.validate(jwt);
        




            return null;

    }
}
