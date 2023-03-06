package com.example.autoconfigtest;

import com.example.extra.service.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication(scanBasePackageClasses = {AutoConfigTestApplication.class, ServiceB.class})
public class AutoConfigTestApplication implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(AutoConfigTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Fetching employees' emails");
        jdbcTemplate.queryForList("select email from employee", String.class)
                .forEach(System.out::println);
    }
}
