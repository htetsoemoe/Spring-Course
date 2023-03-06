package com.demo.configuration.level;

import com.demo.configuration.level.ds.FinancialReport;
import com.demo.configuration.level.service.FileReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration @Profile("file")
public class FileAppConfig {

    @Bean
    public FinancialReport financialReport() {
        return new FinancialReport();
    }

    @Bean
    public FileReportWriter fileReportWriter() {
        return new FileReportWriter();
    }
}
