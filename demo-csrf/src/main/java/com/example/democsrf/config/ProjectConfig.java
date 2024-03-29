package com.example.democsrf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        var  manager = new InMemoryUserDetailsManager();
        var user1 = User.withUsername("john")
                .password("12345")
                .roles("ADMIN")
                .build();

        var user2 = User.withUsername("james")
                .password("12345")
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
        http.httpBasic(); // basic is not form login
/*
        http.authorizeHttpRequests()
                .mvcMatchers(HttpMethod.GET, "/a").authenticated() //need username and password
                .mvcMatchers(HttpMethod.POST, "/a").permitAll()
                .anyRequest().denyAll();


 */
     /*   http.authorizeHttpRequests()
                        .mvcMatchers("/a/b/**").authenticated()
                        .anyRequest().permitAll();

      */

        http.authorizeHttpRequests()
                        .antMatchers("/hello")
                                .authenticated();

       // http.csrf().disable(); // csrf token was produced in POST Method
    }
}
