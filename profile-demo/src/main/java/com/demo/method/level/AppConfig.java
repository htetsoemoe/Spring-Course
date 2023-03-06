package com.demo.method.level;


import com.demo.method.level.dao.DatabaseStoreFinancialReportDao;
import com.demo.method.level.dao.FileStoreFinancialReportDao;
import com.demo.method.level.dao.FinancialDataDao;
import com.demo.method.level.service.DatabaseReportWriter;
import com.demo.method.level.service.FileReportWriter;
import com.demo.method.level.service.FinancialReportService;
import com.demo.method.level.service.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean
    public FinancialReportService financialReportService(FinancialDataDao financialDataDao) {
        return new FinancialReportService(financialDataDao);
    }

    @Bean @Profile("database")
    public FinancialDataDao databaseStoreFinancialDataDao() {
        return new DatabaseStoreFinancialReportDao();
    }

    @Bean @Profile("file")
    public FinancialDataDao fileStoreFinancialDataDao() {
        return new FileStoreFinancialReportDao();
    }

    @Bean @Profile("database")
    public DatabaseReportWriter databaseReportWriter() {
        return new DatabaseReportWriter();
    }

    @Bean @Profile("file")
    public FileReportWriter fileReportWriter() {
        return new FileReportWriter();
    }

    @Bean
    public MyService myService() {
        return new MyService();
    }

}
