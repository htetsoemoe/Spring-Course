package com.example.demoauthorization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        var manager = new InMemoryUserDetailsManager();

        var user1 = User.withUsername("john")
                .password("12345")
                //.authorities("READ")
                //.authorities("ROLE_ADMIN")
                .roles("ADMIN")
                .build();

        var user2 = User.withUsername("james")
                .password("12345")
                //.authorities("WRITE", "READ", "DELETE")//can give authority more than one authority
                //.authorities("ROLE_MANAGER")
                .roles("MANAGER")
                .build();

        manager.createUser(user1);
        manager.createUser(user2);
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();

       // http.authorizeHttpRequests().anyRequest().hasAuthority("WRITE");

      // http.authorizeHttpRequests().anyRequest().hasAnyAuthority("WRITE", "READ");

       // http.authorizeHttpRequests().anyRequest().hasRole("ADMIN");

        http.authorizeHttpRequests()
                .mvcMatchers("/hello").hasRole("ADMIN")
                .mvcMatchers("/greet").hasRole("MANAGER")
                //.anyRequest().permitAll();
                .anyRequest().authenticated();
    }
}
