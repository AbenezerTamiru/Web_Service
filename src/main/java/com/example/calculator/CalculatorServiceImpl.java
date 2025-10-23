package com.example.calculator;

// Add these imports
import java.lang.Override;
import java.lang.System;

import jakarta.jws.WebService;

@WebService(
        endpointInterface = "com.example.calculator.Calculator",
        serviceName = "CalculatorService",
        targetNamespace = "http://calculator.example.com/",
        portName = "CalculatorPort"
)
public class CalculatorServiceImpl implements Calculator {

    @Override
    public double add(double a, double b) {
        System.out.println("Adding: " + a + " + " + b + " = " + (a + b));
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        System.out.println("Subtracting: " + a + " - " + b + " = " + (a - b));
        return a - b;
    }
}