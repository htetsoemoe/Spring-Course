package com.demo.method.level.service;

import com.demo.method.level.dao.FinancialDataDao;

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
