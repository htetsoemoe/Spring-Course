package com.demo;

import com.demo.configuration.DataSourceConfiguration;
import com.demo.service.EmployeeReportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

// There is no Configuration file in this project, we must configure 'Main Class' as Configuration file using @ComponentScan.
@ComponentScan
public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Runner.class);
        context.registerShutdownHook();

        EmployeeReportService employeeReportService = context.getBean(EmployeeReportService.class);
        employeeReportService.printReport();
    }
}
