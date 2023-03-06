package com.example.profilepropertiesdemo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class SpringBean1 {

    @Value("${my.name}")
    private String name;

    @Value("${my.hobby}")
    private String hobby;

    public void printProperties() {
        System.out.println("Name : " + name);
        System.out.println("Hobby : " + hobby);
    }


}
