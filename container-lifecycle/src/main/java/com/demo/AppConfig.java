package com.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public static CustomBeanFactoryPostProcess getCustomBeanFactoryPostProcess() {
        return new CustomBeanFactoryPostProcess();
    }

    @Bean
    public static CustomBeanPostProcessor getCustomBeanPostProcessor() {
        return new CustomBeanPostProcessor();
    }
}
