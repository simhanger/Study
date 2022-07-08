package com.study.ramda;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    private void aaa() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 3);
        Stream<Integer> integerStream = list.stream();
        integerStream.forEach(System.out::println);

        integerStream = list.stream();
        integerStream.forEach(System.out::println);
    }

    private void test() {
        Stream stream = Stream.of("a", "b", "c");
        stream.forEach(System.out::println);

        String[] str = new String[]{"aa", "bb", "cc"};
        Stream<String> stream1 = Arrays.stream(str);
        //stream1.forEach(System.out::println);
        System.out.println(stream1.count());

        int[] intArr = {1, 2, 3, 4};
        IntStream intStream = Arrays.stream(intArr);
        System.out.println(intStream.max().toString());
    }

    public void bbb() {
        IntStream intStream = IntStream.range(1, 5);
        intStream.forEach(System.out::println);
        System.out.println("");

        intStream = IntStream.rangeClosed(1, 5);
        intStream.forEach(System.out::print);

        System.out.println("");

        intStream = IntStream.rangeClosed(1, 10);
        intStream.skip(3).limit(5).forEach(System.out::println);
        System.out.println("");

        intStream = IntStream.rangeClosed(1, 10);
        intStream.filter(i -> i % 2 == 0).forEach(System.out::println);
        System.out.println("");

        String[] fruits = new String[]{"수박", "파인에플", "바나나", "감"};
        Stream<String> stringStream = Stream.of(fruits);
        stringStream
                .sorted()
                .filter(i -> !i.equals("감"))
                .distinct()
                .forEach(System.out::print);
    }

    private void fileTest() {
        Stream<File> fileStream = Stream.of(new File("Ex1.java"), new File("Exasdf"), new File("Ex2.bak"), new File("Ex3.txt"));
        fileStream.map(File::getName)
                .filter(s -> s.indexOf(".") != -1)
                .peek(s -> System.out.println("filename = " + s))  // 작업중간에 결과 확인용으로 사용
                .map(s -> s.substring(s.indexOf(".") + 1))
                .map(String::toUpperCase)
                .distinct()
                .forEach(System.out::println);


        //Stream<String> filenameStream2 = fileStream.map(File::getAbsolutePath);
        //filenameStream2.forEach(System.out::println);
    }

    private void optionaltest() {
        String str = "a";
        if (Optional.ofNullable(str).isPresent()) {
            System.out.println("str = " + str);
        }

        int[] arr = null;
        System.out.println("arr.length = " + Optional.ofNullable(arr));

        Optional<String> opt = Optional.empty();
        String opstr = "a";
        opt = Optional.ofNullable(opstr);
        System.out.println("opt = " + opt);
        System.out.println("opt1 = " + opt.orElse("NUll~!"));
        System.out.println("opt2 = " + opt.isPresent());

        opt.ifPresent(s -> {
            if (s.equals("a")) {
                System.out.println("opt3 is a");
            } else {
                System.out.println("opt3 = " + s);
            }
        });

        Optional<String> optStr = Optional.of("asdf");
        System.out.println("string = " + optStr.get());
        System.out.println("string 갯수 = " + optStr.stream().count());
        System.out.println("길이1 = " + optStr.map(String::length));
        System.out.println("길이2 = " + optStr.map(s -> s.length()));
        System.out.println("길이3 = " + optStr.map(s -> s.length()).get());

        int result = Optional.of("0123")
                .filter(s -> s.length() > 0)
                .map(Integer::parseInt)
                //.get();
                .orElse(-1);
        System.out.println("result = " + result);

    }

    private void collectorsTest(){

    }

    public static void main(String args[]) {

        StreamTest streamTest = new StreamTest();
        //streamTest.aaa();
        //streamTest.test();
        //streamTest.bbb();
        //streamTest.fileTest();
        //streamTest.optionaltest();
        streamTest.collectorsTest();
    }


}
