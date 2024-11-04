package com.example.demo.services;

import com.example.demo.dto.Ex3;

public interface Collatz {
    Ex3 calcCollatz(int step, int current);
    int collatz(int current);
}
