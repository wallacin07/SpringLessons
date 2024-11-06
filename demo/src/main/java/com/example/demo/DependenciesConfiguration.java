package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.dto.Token;
import com.example.demo.services.JWTService;
import com.example.demo.implementations.DefaultJWTService;

@Configuration
public class DependenciesConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

    @Bean
    public JWTService<Token> jwtService() {
        return new DefaultJWTService();
    }
}