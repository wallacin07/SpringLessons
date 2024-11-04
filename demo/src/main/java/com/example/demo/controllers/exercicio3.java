package com.example.demo.controllers;


import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Ex3;
import com.example.demo.implementations.MagicCollatz;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
// @RequestMapping("")
public class exercicio3 {
    
    @GetMapping("/collatz")
    @CrossOrigin(origins = { "http://localhost:5257/" })
    public ResponseEntity<Ex3> sla(@RequestParam(value = "step",defaultValue = "2")int step, @RequestParam(value = "current", defaultValue = "2")int current)   
    {

            MagicCollatz collatz = new MagicCollatz();
            var new_current = collatz.calcCollatz(step, current);

            return ResponseEntity.ok(new_current);
}
}
