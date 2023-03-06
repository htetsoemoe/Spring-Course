package com.demo.service;

import com.demo.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeReportService {

    @Autowired
    private EmployeeDao employeeDao;

    public void printReport() {
        System.out.println("Employee Report Start.");

        System.out.println("Find Employee Emails : ");
        employeeDao.findEmployeeEmails()
                        .forEach(System.out::println);

        System.out.println("Highest Employee Salary : ");
        System.out.println(employeeDao.findEmployeeWithHighestSalary());

        System.out.println("Employee Counts : ");
        System.out.println(employeeDao.findEmployeeCount());

        System.out.println("Find All Employees : ");
        employeeDao.findAllEmployees().forEach(System.out::println);

        System.out.println("Employee Report Stop.");
    }
}
