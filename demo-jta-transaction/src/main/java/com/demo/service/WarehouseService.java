package com.demo.service;

import com.demo.db.employees.dao.EmployeeDao;
import com.demo.db.employees.entities.Employee;
import com.demo.db.product.dao.ProductDao;
import com.demo.db.product.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class WarehouseService {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ProductDao productDao;

    @Transactional
    public void purgeDate() {
        employeeDao.deleteAll();
        productDao.deleteAll();
    }

    @Transactional
    public void saveData() {
        System.out.println("Saving employee 1");
        employeeDao
                .save(new Employee(1, "John", "Doe", "john@gmail.com", "55-55-555", Date.valueOf("2021-04-11"), 300000));
        System.out.println("Saved employee 1...");

        System.out.println("Saving product 1.");
        productDao
                .save(new Product(1, "Jet Ski", 20, 4500f, true));
        System.out.println("Saved product 1...");

        //System.out.println("Throwing exception to revert transaction.");
        //throw new IllegalArgumentException();
    }

    @Transactional
    public void listAllData() {
        System.out.println("listing all employees....");
        employeeDao.findAll().forEach(System.out::println);

        System.out.println("Listing all products....");
        productDao.findAll().forEach(System.out::println);
    }
}
