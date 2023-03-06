package com.example.demohttpmessageconverter.config;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Optional;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        Optional<HttpMessageConverter<?>> foundConverters =
                converters.stream().filter(c -> c instanceof AbstractJackson2HttpMessageConverter).findAny();

        if (foundConverters.isPresent()) {
            AbstractJackson2HttpMessageConverter converter = (AbstractJackson2HttpMessageConverter) foundConverters.get();
            converter.getObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true);
        }
    }
}
