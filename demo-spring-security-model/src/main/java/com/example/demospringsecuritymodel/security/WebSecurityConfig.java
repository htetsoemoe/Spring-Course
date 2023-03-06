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
                .mvcMatchers("/","/home").permitAll()

                .mvcMatchers("/employees").hasRole(EMPLOYEES_PAGE_VIEW)
                .mvcMatchers("/employees/create").hasRole(EMPLOYEES_CREATE)
                .mvcMatchers("/employees/delete/*").hasRole(EMPLOYEES_DELETE)

                .mvcMatchers("/departments").hasRole(DEPARTMENTS_PAGE_VIEW)
                .mvcMatchers("/departments/view/*").hasRole(DEPARTMENTS_PAGE_VIEW)
                .mvcMatchers("/departments/create").hasRole(DEPARTMENTS_CREATE)
                .mvcMatchers("/departments/delete/*").hasRole(DEPARTMENTS_DELETE)

                .mvcMatchers("/c??to?er?").hasRole(CUSTOMERS_PAGE_VIEW)
                .mvcMatchers("/customers/view/*").hasRole(CUSTOMERS_PAGE_VIEW)
                .mvcMatchers("/customers/create").hasRole(CUSTOMERS_CREATE)
                .mvcMatchers("/customers/delete/*").hasRole(CUSTOMERS_DELETE)

                // these lines added while studying ** pattern
//                .mvcMatchers("/**/view/**").hasRole(ALL_VIEW)
//                .mvcMatchers("/**/create/**").hasRole(ALL_CREATE)
//                .mvcMatchers("/**/delete/**").hasRole(ALL_DELETE)

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
                .roles(DEPARTMENTS_PAGE_VIEW, DEPARTMENTS_READ, DEPARTMENTS_CREATE)
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
