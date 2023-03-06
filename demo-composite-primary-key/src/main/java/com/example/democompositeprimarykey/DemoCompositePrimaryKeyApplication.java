package com.example.democompositeprimarykey;

import com.example.democompositeprimarykey.entities.DepartmentId;
import com.example.democompositeprimarykey.service.EmployeeService;
import com.example.democompositeprimarykey.util.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class DemoCompositePrimaryKeyApplication {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(DemoCompositePrimaryKeyApplication.class, args);
    }

//    @Transactional
//    @Override
//    public void run(String... args) throws Exception {
//        employeeService.createDb();
//
//        System.out.println("Department Name : " + employeeService.findDepartmentById(new DepartmentId("M102", "Mandalay")).getName());
//
//        JPAUtil.checkData("select * from department");
//        JPAUtil.checkData("select * from employees");
//    }

    @Bean @Profile("h2")
    public ApplicationRunner runner() {
        return args -> {
            employeeService.createDb();

            System.out.println("Department Name : " + employeeService.findDepartmentById(new DepartmentId("M102", "Mandalay")).getName());

            JPAUtil.checkData("select * from department");
            JPAUtil.checkData("select * from employees");
        };
    }
}
