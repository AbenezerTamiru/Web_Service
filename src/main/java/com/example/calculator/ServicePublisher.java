package com.example.calculator;

// Add these imports
import java.lang.String;
import java.lang.System;
import java.lang.Thread;
import java.lang.InterruptedException;

import jakarta.xml.ws.Endpoint;

public class ServicePublisher {
    public static void main(String[] args) {
        System.out.println("Starting Calculator SOAP Service...");

        // Create and publish the endpoint
        Endpoint endpoint = Endpoint.publish("http://localhost:8080/calculator", new CalculatorServiceImpl());

        System.out.println("✅ Calculator SOAP Service is running at: http://localhost:8080/calculator");
        System.out.println("✅ WSDL available at: http://localhost:8080/calculator?wsdl");
        System.out.println("\nPress Ctrl+C to stop the service...");

        // Keep the service running
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            System.out.println("Service stopped.");
            endpoint.stop();
        }
    }
}