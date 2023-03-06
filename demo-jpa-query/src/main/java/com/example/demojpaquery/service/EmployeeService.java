package com.example.demojpaquery.service;

import com.example.demojpaquery.dao.custom.CustomEmployeeDao;
import com.example.demojpaquery.dao.regular.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CustomEmployeeDao customEmployeeDao;

    @Transactional
    public void queryEmployee() {
        System.out.println("Top 2 Employees By Salary");
        employeeDao.findTop3ByOrderBySalaryDesc().forEach(System.out::println);

        System.out.println("Searching for May War employee...");
        System.out.println(
                employeeDao.findByFirstNameAndLastName("May", "War")
        );

        System.out.println("Employees hired between 12 July 2019 and 12 July 2020");
        employeeDao.findByHireDateBetween(Date.valueOf("2020-07-12"), Date.valueOf("2019-07-12")).forEach(System.out::println);

        System.out.println("Employees order by hire date");
        employeeDao.findByOrderByHireDateDesc().forEach(System.out::println);

        System.out.println();
        System.out.println("Searching for Soe Moe employee with custom DAO");

        System.out.println(customEmployeeDao.findByFirstNameAndLastName("Soe", "Moe"));
    }
}
