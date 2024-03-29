package com.example.demospringsecuritymodel.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

import static com.example.demospringsecuritymodel.security.SecurityRoles.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RoleHierarchy roleHierarchy;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .expressionHandler(expressionHandler())

                .mvcMatchers("/", "/home").permitAll()

                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login-error")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser("john")
                .password(encoder.encode("john"))
                .roles(SUPER_ADMIN)
                .and()
                .withUser("emma")
                .password(encoder.encode("emma"))
                .roles(EMPLOYEES_ADMIN)
                .and()
                .withUser("william")
                .password(encoder.encode("william"))
                .roles(DEPARTMENTS_PAGE_VIEW, DEPARTMENTS_READ, DEPARTMENTS_CREATE, EMPLOYEES_READ, EMPLOYEES_PAGE_VIEW)
                .and()
                .withUser("lucas")
                .password(encoder.encode("lucas"))
                .roles(CUSTOMERS_PAGE_VIEW, CUSTOMERS_READ)
                .and()
                .withUser("tom")
                .password(encoder.encode("tom"))
                .roles();
    }

    private DefaultWebSecurityExpressionHandler expressionHandler() {
        DefaultWebSecurityExpressionHandler expressionHandler =
                new DefaultWebSecurityExpressionHandler();
        expressionHandler.setRoleHierarchy(roleHierarchy);
        return expressionHandler;
    }
}
