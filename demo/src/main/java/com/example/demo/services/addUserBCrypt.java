package com.example.demo.services;

import com.example.demo.dto.Ex6;
import com.example.demo.repositories.UserRepository;

public interface addUserBCrypt {
    boolean newUserBCrypt(Ex6 infUser, UserRepository repo);
}
