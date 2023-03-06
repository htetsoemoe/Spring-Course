package com.demo.component.level.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component @Profile("file")
public class FileReportWriter {
    public FileReportWriter() {
        System.out.println(getClass().getSimpleName() + ":: created.");
    }
}
