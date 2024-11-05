package com.example.demo.controllers;


import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Ex6;
import com.example.demo.model.City;
import com.example.demo.repositories.CitiesRepository;
import com.example.demo.repositories.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
// @RequestMapping("")
public class exercicio6 {

    @Autowired
    UserRepository repo;

    @CrossOrigin(origins = { "http://localhost:5257/" })
    @PostMapping("/create")
    public ResponseEntity<String> newUser(@RequestBody Ex6 infUser)  {

        String emailPost = infUser.email();
        System.out.println(emailPost);
        String usernamePost = infUser.username();
        String senhaPost = infUser.password();
        var User = repo.findByEmail(usernamePost);
        var email = repo.findByEmail(emailPost);

        if (User.isEmpty() || email.isEmpty() || !usernamePost.isEmpty() || !emailPost.isEmpty()) {

            if (senhaPost.length() >= 8 || usernamePost.length() > 4 || emailPost.length() > 4) {
                char[] caracteres = new char[senhaPost.length()];
                Integer haveUpperCase = 0;
                Integer haveLowerCase  = 0;
                Integer haveDigit = 0;
                for (int i = 0; i < senhaPost.length(); i++) {
                    caracteres[i] = senhaPost.charAt(i);
                    haveUpperCase = Character.isUpperCase(caracteres[i]) ? 1 : haveUpperCase;
                    haveDigit = Character.isDigit(caracteres[i]) ? 1 : haveDigit;
                    haveLowerCase = Character.isLowerCase(caracteres[i]) ? 1 : haveLowerCase;
                }
                if (haveDigit == 1 && haveLowerCase == 1 && haveUpperCase == 1) {
                    return ResponseEntity.ok("Tudo ok carai");
                }

            }

        }
        return ResponseEntity.ok("Tudo errado carai");
    }
}