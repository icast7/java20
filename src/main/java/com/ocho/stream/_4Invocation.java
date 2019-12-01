package com.ocho.stream;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class _4Invocation {
    private static long counter;

    private static void wasCalled(){
        counter++;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        counter = 0;
        Stream<String> stream = list.stream().filter(e -> {
           wasCalled();
           return e.contains("2");
        });
        System.out.println(counter);

        Optional<String> stre = list.stream().filter(e -> {
            System.out.println("filter() was called");
            return e.contains("2");
        }).map(e -> {
            System.out.println("map() was called");
            return e.toUpperCase();
        }).findFirst();
    }
}


