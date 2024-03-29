package com.example.demospringsecuritymodel.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.PostConstruct;

@Configuration
public class SecurityStrategyConfiguration {
    @Value("${spring.security.strategy}")
    private String springSecurityStrategy;

    @PostConstruct
    public void init() {
        SecurityContextHolder.setStrategyName(springSecurityStrategy);
    }
}
