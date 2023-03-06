package com.example.demoyml;

import com.example.demoyml.configuration.ApplicationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(ApplicationConfiguration.class)
@SpringBootApplication
public class DemoYmlApplication implements CommandLineRunner {
    @Autowired
    private ApplicationConfiguration applicationConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(DemoYmlApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Configuration injected from properties");
        System.out.println(applicationConfiguration);
    }
}
