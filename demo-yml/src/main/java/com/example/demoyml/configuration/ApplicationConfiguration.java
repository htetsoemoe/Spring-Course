package com.example.demoyml.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Setter
@Getter
@ToString
@ConfigurationProperties(prefix = "app")
public class ApplicationConfiguration {
    // Spring automatically bind with this 'String name' and 'name' from application-dev.yml file
    private String name;
    // Spring automatically bind with this 'String description' and 'description' from application-dev.yml file
    private String description;

    private List<String> servers;

    private Map<String, EnvironmentConfiguration> environments;
}
