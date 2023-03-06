package com.demo.custom.annotations;

import com.demo.custom.annotations.dao.FinancialDataDao;
import com.demo.custom.annotations.service.FinancialReportService;
import com.demo.custom.annotations.service.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public MyService myService() {
        return new MyService();
    }


    public FinancialReportService financialReportService(FinancialDataDao financialDataDao) {
        return new FinancialReportService(financialDataDao);

    }
}
