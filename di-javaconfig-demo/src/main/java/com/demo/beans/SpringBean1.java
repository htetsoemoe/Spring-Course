package com.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

public class SpringBean1 {
    private SpringBean2 springBean2;
    private SpringBean3 springBean3;

    public SpringBean1(SpringBean2 springBean2, SpringBean3 springBean3) {
        this.springBean2 = springBean2;
        this.springBean3 = springBean3;
        System.out.println(getClass().getSimpleName() + "::constructor");
        System.out.println("Before @PostConstruct Method of SpringBean1.");
    }

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct Method of SpringBean1.");
    }

    @Autowired
    public void setQuest(List<Quest> quest) {
        quest.stream()
                .map(q -> q.goQuest())
                .forEach(System.out::println);
    }

    public void sayHello() {
        System.out.println("Hello!");
    }

}
