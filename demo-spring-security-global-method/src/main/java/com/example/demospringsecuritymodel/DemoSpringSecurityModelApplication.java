package com.example.demospringsecuritymodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoSpringSecurityModelApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringSecurityModelApplication.class, args);
    }

}

//Spring Security Code Places to analyze:

//DelegatingFilterProxy.doFilter
//FilterChainProxy.doFilterInternal
//ProviderManager.authenticate
//AffirmativeBased.decide
//RoleVoter.vote
