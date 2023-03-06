package com.demo;


import com.demo.beans.SpringBean1;
import com.demo.beans.SpringBean4;
import com.demo.beans.SpringBean5;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        SpringBean1 springBean1 = context.getBean(SpringBean1.class);
        springBean1.sayHello();

        System.out.println("\n --------- Prototype Scope ----------- \n");

        // SpringBean4 is "Prototype Scope"
        SpringBean4 obj1 = context.getBean(SpringBean4.class);
        SpringBean4 obj2 = context.getBean(SpringBean4.class);
        SpringBean4 obj3 = context.getBean(SpringBean4.class);

//        System.out.println(obj1);
//        System.out.println(obj2);
//        System.out.println(obj3);

        System.out.println("\n --------- Singleton Scope ----------- \n");

        // SpringBean5 is "Singleton Scope"
        SpringBean5 bean5Obj1 = context.getBean(SpringBean5.class);
        SpringBean5 bean5Obj2 = context.getBean(SpringBean5.class);
        SpringBean5 bean5Obj3 = context.getBean(SpringBean5.class);

        System.out.println(bean5Obj1);
        System.out.println(bean5Obj2);
        System.out.println(bean5Obj3);

    }
}
