package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Ex1;
import com.example.demo.implementations.EhPalindrome;



@RestController
@RequestMapping("/reverse")
public class exercicio1 {
    
    

    @GetMapping("/{word}")
    @CrossOrigin(origins = { "http://localhost:5257/" })
    public ResponseEntity<Ex1> login(@PathVariable String word ) 
        
    {  
        EhPalindrome palindromo = new EhPalindrome();
        var resultado = palindromo.palindromo(word);
        
        return ResponseEntity.ok(resultado);
    }
    
}
