package com.zyl.usertest;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Mian4 {
    public static void main(String[] args) {
        System.out.println(IntStream.rangeClosed(0, 100).sum());
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]}).limit(20).map(t -> t[0]).forEach(System.out::println);
        Stream.iterate(0, n -> n + 2).forEach(System.out::println);
    }
}
