package com.study.ramda;

import lombok.Builder;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public class Fruit {
    private String name;
    private int count;

    @Builder
    public Fruit(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String bite() {
        return name + " 한입.";
    }
}
