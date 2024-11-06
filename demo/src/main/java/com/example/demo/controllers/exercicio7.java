package com.example.demo.controllers;


import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Ex6;
import com.example.demo.repositories.UserRepository;
import com.example.demo.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class exercicio7 {

    @Autowired
    UserRepository repo;

    @PatchMapping("/changepassword")
    public ResponseEntity<String> newUser(@RequestBody Ex6 infUser)  {

        String emailPost = infUser.email();
        String usernamePost = infUser.username();
        String senhaPost = infUser.password();
        var Usuario = repo.findByUsername(usernamePost);
        var email = repo.findByEmail(emailPost);

        if (Usuario.size() == 0 && email.size() == 0) {

            if (senhaPost.length() >= 8 && usernamePost.length() > 4 && emailPost.length() > 4) {
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
                if (haveDigit == 1 && haveLowerCase == 1 && haveUpperCase == 1 && emailPost.contains("@")) {
                    Usuario newUser = new Usuario();
                    newUser.setEmail(emailPost);
                    newUser.setPassword(senhaPost);
                    newUser.setUsername(usernamePost);
                    repo.save(newUser);
                    return ResponseEntity.ok("Tudo ok carai");
                }

            }

        }
        return ResponseEntity.ok("Tudo errado carai");
    }
}