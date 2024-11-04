package com.example.demo.implementations;

import com.example.demo.dto.Ex2;
import com.example.demo.services.ImaginaryExp;

public class CalcExp implements ImaginaryExp {

    @Override
    public Ex2 calc(Double A, Double b) {
        Double Re = A* Math.sin(b);
        Double Im = A* Math.cos(b);

        return new Ex2(Re, Im);
    }
    
}
