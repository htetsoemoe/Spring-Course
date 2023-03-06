package com.demo;

import com.demo.beans.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Arrays;

public class Runner1 {
    public static void main(String[] args) {

        ExpressionParser parser = new SpelExpressionParser();

        System.out.println(parser.parseExpression("'Hello'.concat(' World!')").getValue());
        System.out.println(parser.parseExpression("'2 + 2 equals = '.concat(2 + 2)").getValue());
        System.out.println(parser.parseExpression("24 * 60").getValue());
        System.out.println(parser.parseExpression("{1,2,3}").getValue());
        System.out.println(parser.parseExpression("{a:1,b:2,c:3}").getValue());
        System.out.println(Arrays.toString((int[]) parser.parseExpression("new int[]{1,2,3}").getValue()));
        System.out.println(parser.parseExpression("5 < 10").getValue());





       /* AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        SpringBean1 springBean1 = context.getBean(SpringBean1.class);
        System.out.println(springBean1.getTaxId());
        System.out.println(springBean1.getCasesMap());
        System.out.println(springBean1.getDepartmentName());
        System.out.println(springBean1.getStreetName());

        */
    }
}
