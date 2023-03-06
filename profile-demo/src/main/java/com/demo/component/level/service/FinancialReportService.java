package com.demo.component.level.service;

import com.demo.component.level.dao.FinancialDataDao;
import org.springframework.stereotype.Component;

@Component
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
