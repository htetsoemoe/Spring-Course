package com.example.demoonetoone.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String streetName;
    private String city;
    private String zipCode;

    @OneToOne(mappedBy = "address")     // "Address" is not an ownership table because we use mappedBy
    private Customer customer;

    public Address() {
    }

    public Address(String streetName, String city, String zipCode) {
        this.streetName = streetName;
        this.city = city;
        this.zipCode = zipCode;
    }
}
