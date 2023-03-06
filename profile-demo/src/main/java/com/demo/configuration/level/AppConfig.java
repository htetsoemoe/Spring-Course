package com.demo.configuration.level;

import com.demo.configuration.level.dao.FinancialDataDao;
import com.demo.configuration.level.service.FinancialReportService;
import com.demo.configuration.level.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DatabaseAppConfig.class, FileAppConfig.class})
public class AppConfig {


    @Bean
    public MyService myService() {
        return new MyService();
    }

    @Bean @Autowired
    public FinancialReportService financialReportService(FinancialDataDao financialDataDao) {
        return new FinancialReportService(financialDataDao);
    }
}
