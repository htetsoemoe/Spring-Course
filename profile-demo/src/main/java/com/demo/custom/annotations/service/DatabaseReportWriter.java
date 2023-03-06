package com.demo.custom.annotations.service;

import com.demo.custom.annotations.annotations.DatabaseProfile;
import org.springframework.stereotype.Component;

@Component @DatabaseProfile
public class DatabaseReportWriter {
    public DatabaseReportWriter() {

        System.out.println(getClass().getSimpleName() + ":: created.");
    }
}
