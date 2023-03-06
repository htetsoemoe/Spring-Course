package com.example.demofilterchain.config;

import com.example.demofilterchain.filter.AuthenticationLoggingFilter;
import com.example.demofilterchain.filter.RequestValidationFilter;
import com.example.demofilterchain.filter.StaticKeyAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private StaticKeyAuthenticationFilter filter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    /* http.addFilterBefore(
                new RequestValidationFilter(),
                BasicAuthenticationFilter.class
        ).addFilterAfter(
                new AuthenticationLoggingFilter(),
                BasicAuthenticationFilter.class
        ).authorizeHttpRequests()
                .anyRequest().permitAll();
    }


     */


        http.addFilterAt(filter, BasicAuthenticationFilter.class)
                .authorizeHttpRequests()
                .anyRequest()
                .permitAll();
    }
}
