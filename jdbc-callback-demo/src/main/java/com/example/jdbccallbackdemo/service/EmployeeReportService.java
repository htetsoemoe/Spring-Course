package com.example.jdbccallbackdemo.service;

import com.example.jdbccallbackdemo.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeReportService {
    @Autowired
    private EmployeeDao employeeDao;

    public void printReport() {
        System.out.println("Employee Report Start.");

        System.out.println("Employee List");
        employeeDao.findEmployees()
                        .forEach(System.out::println);

        System.out.println("Employee Average Salary Calculated Row By Row");
        System.out.println(employeeDao.findAverageSalaryRowByRow());

        System.out.println("Employee Average Salary Calculated on Entire Result Set");
        System.out.println(employeeDao.findAverageSalaryCalculateOnEntireResultSet());

        System.out.println("Employees Average Salary SQL Level ");
        System.out.println(employeeDao.findAverageSalarySqlLevel());

        System.out.println("Employees Average Salary Modern String API");
        System.out.println(employeeDao.findAverageSalaryModernImplementation());

        System.out.println("Employee ID Found Based On Email");
        System.out.println(employeeDao.findEmployeeIdFromEmail("cherry@gmail.com"));

        System.out.println("Employee Report Stop.");
    }
}
