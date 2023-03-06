package com.demo.configuration.level.service;

import com.demo.configuration.level.dao.FinancialDataDao;
import org.springframework.stereotype.Component;


public class FinancialReportService {
    //injection is happening here OR @Autowired
    private final FinancialDataDao financialDataDao;

    public FinancialReportService(FinancialDataDao financialDataDao) {
        this.financialDataDao = financialDataDao;
    }

    public void generateReport() {
        financialDataDao.findFinancialReport();
    }

}
