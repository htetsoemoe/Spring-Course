package com.demo.component.level.dao;

import com.demo.component.level.ds.FinancialReport;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component @Profile("database")
public class DatabaseStoreFinancialReportDao implements FinancialDataDao {
    @Override
    public FinancialReport findFinancialReport() {
        System.out.println("Database Financial Report:: DatabaseStoreFinancialReportDao");
        return null;
    }
}
