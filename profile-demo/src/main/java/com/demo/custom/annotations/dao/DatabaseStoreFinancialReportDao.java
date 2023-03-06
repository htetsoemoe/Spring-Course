package com.demo.custom.annotations.dao;

import com.demo.custom.annotations.annotations.DatabaseProfile;
import com.demo.custom.annotations.ds.FinancialReport;
import org.springframework.stereotype.Component;

@DatabaseProfile @Component
public class DatabaseStoreFinancialReportDao implements FinancialDataDao {
    @Override
    public FinancialReport findFinancialReport() {
        System.out.println("Database Financial Report::");
        return null;
    }
}
