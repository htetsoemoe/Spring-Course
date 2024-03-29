package com.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(String.format("%s :: postProcessBeforeInitialization %s %s", getClass().getSimpleName(),
                bean.getClass().getSimpleName(), beanName));
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(String.format("%s :: postProcessAfterInitialization %s %s", getClass().getSimpleName(),
                bean.getClass().getSimpleName(), beanName ));
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
