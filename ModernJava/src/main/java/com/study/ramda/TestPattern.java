package com.study.ramda;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestPattern {

    public static void main(String args[]) {
        TestPattern testPattern = new TestPattern();

        Fruit fruit1 = Fruit.builder()
                .name("바나나")
                .count(10)
                .build();

        log.debug("fruit1 = {}", fruit1.toString());
        log.debug("-> {}", fruit1.bite());

        Fruit fruit2 = Fruit.builder()
                .name("사과")
                .count(20)
                .build();
        log.debug("fruit2 = {}", fruit2.toString());
        log.debug("-> {}", fruit2.bite());

    }


}

