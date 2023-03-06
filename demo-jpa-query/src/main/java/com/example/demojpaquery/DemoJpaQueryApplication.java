package com.example.demojpaquery;

import com.example.demojpaquery.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJpaQueryApplication implements CommandLineRunner {
    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(DemoJpaQueryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeService.queryEmployee();
    }
}
