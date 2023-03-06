package com.demo.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class SpringBean5 {
    public SpringBean5() {
        System.out.println(getClass().getSimpleName() + "::constructor");
    }
}
