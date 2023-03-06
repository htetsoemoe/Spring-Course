package com.demo.component.level.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component @Profile("database")
public class DatabaseReportWriter {
    public DatabaseReportWriter() {

        System.out.println(getClass().getSimpleName() + ":: created.");
    }
}
