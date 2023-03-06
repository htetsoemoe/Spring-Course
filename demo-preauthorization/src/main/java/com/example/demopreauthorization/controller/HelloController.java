package com.example.demopreauthorization.controller;

import com.example.demopreauthorization.model.Employee;
import com.example.demopreauthorization.service.BookService;
import com.example.demopreauthorization.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private NameService nameService;

    @Autowired
    private BookService bookService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello!, " + nameService.getName();
    }

    @GetMapping("/secrete/names/{name}")
    public List<String> names(@PathVariable String name) {
        return nameService.getSecreteNames(name);
    }

    @GetMapping("/book/details/{name}")
    public Employee getDetails(@PathVariable String name) {
        return bookService.getBookDetails(name);
    }
}
