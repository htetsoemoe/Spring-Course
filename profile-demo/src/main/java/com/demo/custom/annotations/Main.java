package com.demo.custom.annotations;


import com.demo.custom.annotations.service.FinancialReportService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();


        //Activate Profile
        context.getEnvironment().setActiveProfiles("file");
        context.register(AppConfig.class);
        context.refresh();


        FinancialReportService financialReportService = context.getBean(FinancialReportService.class);

        financialReportService.generateReport();
    }
}
