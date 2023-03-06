package com.demo.configuration.level;

import com.demo.configuration.level.ds.FinancialReport;
import com.demo.configuration.level.service.DatabaseReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration @Profile("database")
public class DatabaseAppConfig {

    @Bean
    public FinancialReport financialReport() {
        return new FinancialReport();
    }

    @Bean
    public DatabaseReportWriter databaseReportWriter() {
        return new DatabaseReportWriter();

    }
}
