package com.example.demo.implementations;

import com.example.demo.dto.Ex3;
import com.example.demo.services.Collatz;

public class MagicCollatz implements Collatz {


    @Override
    public Ex3 calcCollatz(int step, int current) {
            int new_current = current;
            if (step <= 0 || current <= 0) {
                return new Ex3(7);
            }
            
            for (int i = 0; i < step; i++) {
                new_current = collatz(new_current);
            }

            return new Ex3(new_current);
    }

    @Override
    public int collatz(int current) {
        if (current % 2 == 0) {
            return (int) (current /2);
        }
        return (int) (3 * current + 1);
    }
    
}
