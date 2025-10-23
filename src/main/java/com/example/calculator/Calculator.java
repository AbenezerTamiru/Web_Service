package com.example.calculator;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(name = "Calculator", targetNamespace = "http://calculator.example.com/")
public interface Calculator {

    @WebMethod
    double add(
            @WebParam(name = "a") double a,
            @WebParam(name = "b") double b);

    @WebMethod
    double subtract(
            @WebParam(name = "a") double a,
            @WebParam(name = "b") double b);
}