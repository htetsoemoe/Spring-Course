package com.example.democustomizecsrftoken.config;

import com.example.democustomizecsrftoken.csrf.CustomCsrfTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CsrfTokenRepository customCsrfTokenRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf(
                c -> {
                    c.csrfTokenRepository(customCsrfTokenRepository);
                }
        );

        http.authorizeHttpRequests()
                .anyRequest()
                .permitAll();
    }
}
