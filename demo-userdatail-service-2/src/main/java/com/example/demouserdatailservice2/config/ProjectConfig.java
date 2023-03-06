package com.example.demouserdatailservice2.config;

import com.example.demouserdatailservice2.model.User;
import com.example.demouserdatailservice2.services.InMemoryUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class ProjectConfig {


    // UserDetailsService manipulates UserDetails
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails u1 = new User("john", "12345", "read");
        UserDetails u2 = new User("james", "12345", "read");
        List<UserDetails> users = List.of(u1, u2);
        return new InMemoryUserDetailService(users);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
