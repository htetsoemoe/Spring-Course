package com.demo;

import org.springframework.stereotype.Component;

@Component
public class Address {
    private String streetName = "LP Street";

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
