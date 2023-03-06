package com.demo.service;

import com.demo.dao.EmployeeDao;
import com.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public void saveAllEmployees() {
        System.out.println("Saving All Employees.");

        employeeDao
                .save(new Employee(1, "John", "Doe", "john@gmail.com", "55-55-222", Date.valueOf("2020-8-1"), 300000));

        employeeDao
                .save(new Employee(2, "L", "P", "lp@gmail.com", "55-55-123", Date.valueOf("2019-2-1"), 400000));

        employeeDao
                .save(new Employee(3, "Ko", "Htet", "htet@gmail.com", "55-55-908", Date.valueOf("2018-1-1"), 500000));


        System.out.println("Saved All Employees.....");
    }

    public void listAllEmployees() {
        System.out.println("Listing all employees.");

        employeeDao.findAll().forEach(System.out::println);
    }
}
