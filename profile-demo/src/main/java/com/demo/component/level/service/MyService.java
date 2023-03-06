package com.demo.component.level.service;

import org.springframework.stereotype.Component;

@Component
public class MyService {

    public MyService() {
        System.out.println(getClass().getSimpleName() + ":: created.");
    }
}
