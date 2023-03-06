package com.example.demospringrest1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    @Column(unique = true, nullable = false)
    private String firstName;
    private String lastName;
    private String address;

    public Customer() {
    }
}
