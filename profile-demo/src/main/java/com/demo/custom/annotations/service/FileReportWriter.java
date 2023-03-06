package com.demo.custom.annotations.service;

import com.demo.custom.annotations.annotations.FileProfile;
import org.springframework.stereotype.Component;

@Component @FileProfile
public class FileReportWriter {

    public FileReportWriter() {
        System.out.println(getClass().getSimpleName() + ":: created.");
    }
}
