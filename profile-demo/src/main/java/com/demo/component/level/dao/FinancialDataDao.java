package com.demo.component.level.dao;

import com.demo.component.level.ds.FinancialReport;
import org.springframework.stereotype.Component;

@Component
public interface FinancialDataDao {
    FinancialReport findFinancialReport();
}
