package com.example.autoconfigtest.service;

import org.springframework.stereotype.Component;

@Component
public class ServiceA {
    public ServiceA() {
        System.out.println("Service A created.");
    }
}
