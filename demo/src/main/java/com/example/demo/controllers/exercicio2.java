package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Ex2;
import com.example.demo.implementations.CalcExp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
// @RequestMapping("")
public class exercicio2 {
    
    @GetMapping("/imaexp")
    @CrossOrigin(origins = { "http://localhost:5257/" })
    public ResponseEntity<Ex2> login(@RequestParam(value = "A", defaultValue = "2")Double A,@RequestParam(value = "b",defaultValue = "2") Double b) {
                CalcExp nums = new CalcExp();
                var results = nums.calc(A, b);
            return ResponseEntity.ok(results);
    }
    
}
