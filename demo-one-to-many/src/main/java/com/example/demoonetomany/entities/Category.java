package com.example.demoonetomany.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    //1/  @OneToMany
    //@OneToMany(cascade = CascadeType.PERSIST)
    // bi direction
    //@JoinColumn(name = "category_id")    if we add @JoinColumn, there's no join table

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "category")//mappedBy is "Reverse Ownership" so this table isn't "Ownership Table".
    private List<Product> products = new
            ArrayList<>();


    //Helper Methods
    public void addProduct(Product product) {
        product.setCategory(this);//joins product with category
        products.add(product);
    }

    public void removeProduct(Product product) {
        product.setCategory(null);//removes product form category
        this.products.remove(product);
    }

}
