package com.demo;

import com.demo.beans.SpringBean5;
import com.demo.beans.SpringBean6;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(lazyInit = true)
@Lazy

@PropertySource("classpath:/app-defaults.properties")
public class AppConfig {



    @Bean //@Lazy
    public SpringBean5 springBean5() {
        return new SpringBean5();
    }

    @Bean
    public SpringBean6 springBean6() {
        return new SpringBean6();
    }

}
