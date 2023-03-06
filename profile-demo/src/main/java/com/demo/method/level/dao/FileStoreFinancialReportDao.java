package com.demo.method.level.dao;

import com.demo.method.level.ds.FinancialReport;

public class FileStoreFinancialReportDao implements FinancialDataDao{
    @Override
    public FinancialReport findFinancialReport() {
        System.out.println("File Store Financial Report :: FileStoreFinancialReportDao");
        return null;
    }
}
