package com.demo.custom.annotations.dao;

import com.demo.custom.annotations.annotations.FileProfile;
import com.demo.custom.annotations.ds.FinancialReport;
import org.springframework.stereotype.Component;

@FileProfile @Component
public class FileStoreFinancialReportDao implements FinancialDataDao {
    @Override
    public FinancialReport findFinancialReport() {
        System.out.println("File Store Financial Report");
        return null;
    }
}
