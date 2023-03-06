package com.demo.method.level.dao;

import com.demo.method.level.ds.FinancialReport;

public class DatabaseStoreFinancialReportDao implements FinancialDataDao{
    @Override
    public FinancialReport findFinancialReport() {
        System.out.println("Database Store Financial Report:: DatabaseStoreFinancialReportDao");
        return null;
    }
}
