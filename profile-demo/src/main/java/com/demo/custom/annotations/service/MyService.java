package com.demo.custom.annotations.service;

import org.springframework.stereotype.Component;

@Component
public class MyService {

    public MyService() {
        System.out.println(getClass().getSimpleName() + ":: created.");
    }
}
