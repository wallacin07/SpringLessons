package com.example.demo.controllers;


import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.City;
import com.example.demo.repositories.CitiesRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
// @RequestMapping("")
public class exercicio5 {
        @Autowired
        CitiesRepository repo;
        @CrossOrigin(origins = { "http://localhost:5257/" })
    
    
    @GetMapping("/cities")
    public ResponseEntity<List<City>> tudo()  {

        var cidades = repo.findAll();

        if (cidades.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        return new ResponseEntity<>(cidades, HttpStatus.OK);
    }

    @CrossOrigin(origins = { "http://localhost:5257/" })
    @GetMapping("/cities/{query}")
    public ResponseEntity<List<City>> alguns(@PathVariable String query )  {

        var cidades = repo.findByCityContainingOrStateContainingOrCountryContaining(query, query, query);

        if (cidades.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        return new ResponseEntity<>(cidades, HttpStatus.OK);
    }
}
