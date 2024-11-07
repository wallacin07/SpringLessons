package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Ex6;
import com.example.demo.implementations.AdicionandoUsuarioBCrypt;
import com.example.demo.repositories.UserRepository;

@RestController
public class exercicio8 {
    
    @Autowired
    UserRepository repo;

    @PostMapping("/user")
    public ResponseEntity<String> newUserBCrypt(@RequestBody Ex6 infUser)  {
        System.out.println("olaa");
        var createUser = new AdicionandoUsuarioBCrypt();
        if (createUser.newUserBCrypt(infUser, repo)) {
            return ResponseEntity.ok("ok");
        }
        return ResponseEntity.ok("errado");
    }
}
