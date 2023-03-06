package com.demo.db.product.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    @Id
    private Integer id;
    private String name;
    private int quantity;
    private float price;
    private boolean available;

    public Product() {
    }
}
