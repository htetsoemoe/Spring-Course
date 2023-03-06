package com.example.demoonetoone.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String hobby;

    //using bi direction, Customer is a foreign key ownership table
    @OneToOne
    private Address address;

    public Customer() {

    }

    public Customer(String name, String hobby) {
        this.name = name;
        this.hobby = hobby;
    }
}
