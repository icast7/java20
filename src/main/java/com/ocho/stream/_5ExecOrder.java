package com.ocho.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class _5ExecOrder {
    private static long counter;
    private static void wasCalled() {
        counter++;
        System.out.format("Called %d times.%n", counter);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        list.stream().map(e -> {
          wasCalled();
          return e.substring(0, 3);
        }).skip(2).count();
        System.out.println("- - - - - - - - ");
        counter = 0;
        list.stream().skip(2).map(e -> {
            wasCalled();
            return e.substring(0, 3);
        }).count();

    }


}
