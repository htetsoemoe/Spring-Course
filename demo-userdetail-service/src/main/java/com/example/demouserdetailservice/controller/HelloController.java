package com.example.demouserdetailservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // curl -u john:12345 http://localhost:8080/hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }
}
