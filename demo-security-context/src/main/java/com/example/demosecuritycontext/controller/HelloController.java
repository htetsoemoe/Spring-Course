package com.example.demosecuritycontext.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.concurrent.DelegatingSecurityContextCallable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();

        return "Hello " + auth.getName() + "!";
    }

    @GetMapping("/greet")
    public String greet(Authentication authentication) {
        return "Hello " + authentication.getName() + "!";
    }

    @GetMapping("/bye")
    @Async
    public String goodbye() {
//        SecurityContext context = SecurityContextHolder.getContext();
//        Authentication auth = context.getAuthentication();
//
//        return "Hello " + auth.getName() + "!";

        SecurityContext context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();
        return "Username " + name;
    }

    @GetMapping("/algo")
    public String amazingAlgo() throws Exception {
        // this is callable thread
        Callable<String> task = () -> {
          SecurityContext context = SecurityContextHolder.getContext();
          return context.getAuthentication().getName();
        };

        // running thread
        ExecutorService e = Executors.newCachedThreadPool();
        try {
            var contextTask = new DelegatingSecurityContextCallable<>(task);
            return "Amazing Algo " + e.submit(contextTask).get() + "!";
        } finally {
            e.shutdown();
        }
    }

}
