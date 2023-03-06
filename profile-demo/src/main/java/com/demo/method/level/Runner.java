package com.demo.method.level;

import com.demo.method.level.service.FinancialReportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();


        //Activate Profile
        context.getEnvironment().setActiveProfiles("database");
        context.register(AppConfig.class);
        context.refresh();


        FinancialReportService financialReportService = context.getBean(FinancialReportService.class);

        financialReportService.generateReport();
    }
}
