package com.bilski.summer.context;

import com.bilski.summer.annotation.Autowired;
import com.bilski.summer.annotation.Component;
import com.bilski.summer.exception.BeanInitializationException;
import org.reflections.Reflections;
import org.reflections.scanners.*;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Set;

public class ApplicationContext {
    private final HashMap<String, Object> beans = new HashMap<>();
    private final Reflections reflections = new Reflections("");
    public void initialize() {
        Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(Component.class);
        for(Class annotatedClass : annotatedClasses) {
            resolveDependenciesForBean(annotatedClass);
        }
    }

    private void resolveDependenciesForBean(Class annotatedClass) {
        System.out.println("Class: " + annotatedClass.getName());
        Constructor<?>[] constructors = annotatedClass.getDeclaredConstructors();
        Constructor constructorToResolve;
        if(constructors.length == 1) {
            constructorToResolve = constructors[0];
        } else {
//            Set<Constructor> annotatedConstructors = reflections.getConstructorsAnnotatedWith(Autowired.class);
            throw new BeanInitializationException();
        }

        Class<?>[] parameterTypes = constructorToResolve.getParameterTypes();
        System.out.println("Parameter types: ");
        for(Class<?> parameterType : parameterTypes) {
            System.out.println(parameterType);
        }
    }
}
