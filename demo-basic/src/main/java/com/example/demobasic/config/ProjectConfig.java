package com.example.demobasic.config;

import com.example.demobasic.handlers.CustomAuthenticationFailureHandler;
import com.example.demobasic.handlers.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationSuccessHandler successHandler;
    @Autowired
    private CustomAuthenticationFailureHandler failureHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.httpBasic();
        /* http.httpBasic(c -> {
            c.realmName("OTHER");
            c.authenticationEntryPoint(new CustomEntryPoint());

        });

         */

        //there's no login, redirect to login page.
        http.formLogin()
                .successHandler(successHandler)
                        .failureHandler(failureHandler)
                                .and()
                                        .httpBasic();
                       // .defaultSuccessUrl("/hello", true);

        http.authorizeHttpRequests().anyRequest().authenticated();
    }
}
