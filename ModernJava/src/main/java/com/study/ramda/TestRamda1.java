package com.study.ramda;

import java.util.function.Function;

@FunctionalInterface
interface MyFunction{
    public abstract void run(int a);
}


public class TestRamda1 {

    static void execute(MyFunction myFunction){
        myFunction.run(100);
    }

    static MyFunction getMyfunction(){
        MyFunction myFunction = (a) -> System.out.println("마이펑션 가져오기 - " + a);
        return myFunction;
    }

    public static void main(String args[]){
        MyFunction myFunction = new MyFunction() {
            @Override
            public void run(int a) {
                System.out.println("함수형인터페이스 - " + a);
            }
        };

        myFunction.run(10);

        MyFunction myFunction1 = (a) -> System.out.println("이거 자체가 run() - " + a);
        myFunction1.run(20);
        System.out.println("----------simhanger2-");
        execute(myFunction1);
        System.out.println("-----------main1-----------");

        getMyfunction().run(200);

        execute((a) -> System.out.println("Hi - " + 1000));

        Function<Integer, Integer> f = i -> i/10 * 10;
        System.out.println("-> " + f.apply(25));

    }
}
