package com.demo.framework.util;

import com.demo.framework.controller.ControllerMapping;
import com.demo.framework.controller.IController;
import org.reflections.Reflections;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ApplicationControllersFinder {

    // fourth
    public Map<String, IController> findController() {
        return new Reflections()
                .getTypesAnnotatedWith(ControllerMapping.class)
                .stream()
                .map(this::getAsControllerClass)
                .map(this::getControllerInstance)
                .collect(Collectors.toMap(this::getUri, Function.identity()));
    }


    // third
    private Class<IController> getAsControllerClass(Class<?> controller) {
        return (Class<IController>) controller;
    }

    // second
    private IController getControllerInstance(Class<IController> controller) {
        try {
            return controller.getConstructor().newInstance();
        }catch (Exception e) {
            throw new RuntimeException(
                    String.format("Error occur while creating instance of controller %s : %s", controller.getSimpleName()
                            ,e.getMessage()),
                    e
            );
        }
    }

    // first
    private String getUri(IController controller) {
        return controller.getClass().getAnnotation(ControllerMapping.class).value();
    }
}
