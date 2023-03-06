package com.example.demoonetomany;

import com.example.demoonetomany.service.ProductService;
import com.example.demoonetomany.util.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoOneToManyApplication implements CommandLineRunner {
    @Autowired
    private ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(DemoOneToManyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Create DB -------------------------------------");
        productService.createDB();
        System.out.println("-----------------------------------------------");

        System.out.println("Insert New Product to Category");
        productService.insertNewProductByCategoryName("Fruits");
        System.out.println("-----------------------------------------------");

        System.out.println("Delete on First Product : ");
        productService.deleteFirstProduct();
        System.out.println("-----------------------------------------------");

        System.out.println("Delete on Last Product : ");
        productService.deleteLastProduct();
        System.out.println("-----------------------------------------------");

        JPAUtil.checkData("select * from category");
        JPAUtil.checkData("select * from product");
        //JPAUtil.checkData("select * from category_products");
    }
}
