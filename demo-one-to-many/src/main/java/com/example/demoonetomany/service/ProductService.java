package com.example.demoonetomany.service;

import com.example.demoonetomany.Repository.CategoryRepository;
import com.example.demoonetomany.entities.Category;
import com.example.demoonetomany.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public void createDB() {
        Category c1 = new Category();
        c1.setName("Fruits");

        Category c2 = new Category();
        c2.setName("Meats");

        Product p1=new Product("Apple",2000, 100);
        Product p2=new Product("Orange",1500, 100);

        Product p3=new Product("Chicken",15000, 100);
        Product p4=new Product("Fish",10000, 100);

        c1.addProduct(p1);
        c1.addProduct(p2);

        c2.addProduct(p3);
        c2.addProduct(p4);

        categoryRepository.save(c1);
        categoryRepository.save(c2);

    }

    @Transactional
    public void insertNewProductByCategoryName(String categoryName) {
        Category category = categoryRepository.fetchByName(categoryName);

        Product product = new Product("Grape", 4000, 100);
        category.addProduct(product);
        categoryRepository.save(category);

    }

    @Transactional
    public void deleteLastProduct() {
        Category category = categoryRepository.fetchByName("Fruits");
        List<Product> products = category.getProducts();
        category.removeProduct(products.get(products.size() - 1));
    }

    @Transactional
    public void deleteFirstProduct() {
        Category category = categoryRepository.fetchByName("Meats");
        List<Product> products = category.getProducts();
        category.removeProduct(products.get(products.size() - 1));
    }
}
