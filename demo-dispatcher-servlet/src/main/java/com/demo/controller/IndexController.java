package com.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //can handle request object
public class IndexController {


    @GetMapping("/")
    public String index() {
        return "index";
    }
}
