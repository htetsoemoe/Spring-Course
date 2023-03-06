package com.demo.java.java11;

import com.demo.java.JavaEnvInfo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnJava(value = JavaVersion.ELEVEN)
public class Java11AutoConfig {

    @Bean
    public JavaEnvInfo javaEnvInfo() {
        return new Java11EnvInfo();
    }
}
