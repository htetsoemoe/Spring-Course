package com.example.demosecurityfilterchain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecreteResourcesController {

    @GetMapping("/secrete-resources")
    public String index() {
        return "secrete-resources";
    }
}
