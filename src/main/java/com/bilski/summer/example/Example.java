package com.bilski.summer.example;

import com.bilski.summer.annotation.Component;

@Component
public class Example {
    private final AnotherExample anotherExample;
    public Example(AnotherExample anotherExample) {
        this.anotherExample = anotherExample;
    }
}
