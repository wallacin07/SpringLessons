package com.example.demo.services;

import com.example.demo.dto.Ex6;
import com.example.demo.repositories.UserRepository;

public interface addUser {
    Boolean addUsuario(Ex6 infUser, UserRepository repo);
}
