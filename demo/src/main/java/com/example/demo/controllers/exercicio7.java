package com.example.demo.controllers;


import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Ex7;
import com.example.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class exercicio7 {

    @Autowired
    UserRepository repo;

    @PatchMapping("/changepassword")
    public ResponseEntity<String> newUser(@RequestBody Ex7 infUser)  {
        
        String usernamePacth = infUser.username();
        String senhaPacth = infUser.password();
        String newPasswordPacth = infUser.newPassword();
        String repeatPasswordPatch = infUser.repeatPassword();

        var usuarios = repo.findByUsername(usernamePacth);
        var usuario = usuarios.get(0);

        if (!usuario.getPassword().equals(senhaPacth)) {
            return new ResponseEntity<>("Senha incorreta", HttpStatus.BAD_REQUEST);
        }

        if (!newPasswordPacth.equals(repeatPasswordPatch)) {
            return new ResponseEntity<>("As senhas não batem", HttpStatus.BAD_REQUEST);
        }

        usuario.setPassword(newPasswordPacth);
        repo.save(usuario);
        
        return ResponseEntity.ok("Senha modificada com sucesso");
    }
}