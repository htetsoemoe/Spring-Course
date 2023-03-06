package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@ComponentScan
public class ApplicationConfig {
    @Autowired
    private ApplicationContext applicationContext;
    //ApplicationContext is an interface, its subclasses are AnnotationConfigApplicationContext, AnnotationConfigWebApplicationContext

    @Bean
    // writing template resolver
    public SpringResourceTemplateResolver springTemplateResource() {
        SpringResourceTemplateResolver springResourceTemplateResolver =
                new SpringResourceTemplateResolver();

        springResourceTemplateResolver.setApplicationContext(applicationContext);
        springResourceTemplateResolver.setPrefix("/WEB-INF/views/");
        springResourceTemplateResolver.setSuffix(".html");
        return springResourceTemplateResolver;
    }

    // connect template resolver with Spring Template Engine
    @Bean
    public SpringTemplateEngine springTemplateEngine() {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(springTemplateResource());
        return springTemplateEngine;
    }

    @Bean
    // connect Spring Template Engine with View Resolver
    public ViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(springTemplateEngine());
        return viewResolver;
    }

}
