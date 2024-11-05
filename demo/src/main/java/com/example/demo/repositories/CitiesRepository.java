package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.City;

@Repository
public interface CitiesRepository  extends JpaRepository<City, Long>{
    // Retorna todas as cidades
    @SuppressWarnings("null")
    List<City> findAll();

    // Retorna cidades que contêm um nome de cidade, estado ou país parcialmente correspondente
    List<City> findByCityContainingOrStateContainingOrCountryContaining(
            String city, String state, String country);
}
