package com.demo.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SpringBean4 {
    public SpringBean4() {
        System.out.println(getClass().getSimpleName() + "::constructor");
    }
}
