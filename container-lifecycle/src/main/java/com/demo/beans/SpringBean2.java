package com.demo.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SpringBean2 {
    public SpringBean2() {
        System.out.println(getClass().getSimpleName() + "::constructor");
    }

    @PostConstruct      //lifecycle callback, must be void
    public void init() {
        System.out.println(getClass().getSimpleName() + "::init");
    }

    @PreDestroy     //lifecycle callback, must be void
    public void destroy() {
        System.out.println(getClass().getSimpleName() + "::destroy");
    }
}
