package com.demo.beans;

import org.springframework.stereotype.Component;

@Component
public class SpringBean1 {
    public SpringBean1() {
        System.out.println("Creating " + getClass().getSimpleName());
    }
}
