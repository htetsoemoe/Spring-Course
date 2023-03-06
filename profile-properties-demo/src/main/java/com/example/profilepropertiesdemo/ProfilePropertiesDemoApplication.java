package com.example.profilepropertiesdemo;

import com.example.profilepropertiesdemo.beans.SpringBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProfilePropertiesDemoApplication implements CommandLineRunner {
    //@Autowired
    private final SpringBean1 springBean1;

    public ProfilePropertiesDemoApplication(SpringBean1 springBean1) {
        this.springBean1 = springBean1;
    }


    public static void main(String[] args) {
        SpringApplication.run(ProfilePropertiesDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        springBean1.printProperties();
    }


}
