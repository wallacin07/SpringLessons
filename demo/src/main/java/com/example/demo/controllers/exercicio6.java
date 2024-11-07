package com.example.demo.controllers;


import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Ex6;
import com.example.demo.implementations.AdicionandoUser;
import com.example.demo.repositories.UserRepository;
import com.example.demo.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class exercicio6 {

    @Autowired
    UserRepository repo;

    @PostMapping("/create")
    public ResponseEntity<String> newUser(@RequestBody Ex6 infUser)  {

        var createUser = new AdicionandoUser();
        if (createUser.addUsuario(infUser, repo)) {
            return ResponseEntity.ok("ok ");
        }

        return ResponseEntity.ok("errado");
    }
}