package com.example.demomvcscope.bean;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

@Data
@Component
@ApplicationScope
public class ApplicationScopeBean {
    private Integer value;
}
