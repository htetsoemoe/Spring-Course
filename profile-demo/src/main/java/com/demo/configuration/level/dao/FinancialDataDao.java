package com.demo.configuration.level.dao;

import com.demo.configuration.level.ds.FinancialReport;
import org.springframework.stereotype.Component;


public interface FinancialDataDao {
    FinancialReport findFinancialReport();
}
