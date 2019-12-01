package com.ocho.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _6Reduction {
    public static void main(String[] args) {
        OptionalInt reduced1 = IntStream.range(1, 4).reduce((a, b) -> a + b);
        System.out.println("Reduced 1: " + reduced1);

        int reduced2 = IntStream.range(1, 4).reduce(0, (a, b) -> a + b);
        System.out.println("Reduced 2: " + reduced2);

        int reducedParams = Stream.of(1, 2, 3).reduce(5,
                (a, b) -> a + b, (a, b) -> {
                    System.out.println("+ Combiner was called.");
                    return a + b;
                });
        System.out.println("Reduced 3: " + reducedParams);

        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream()
                .reduce(5, (a, b) -> a + b, (a, b) -> {
                    System.out.println("* Combiner was called. a:" + a + " b:" + b);
                    return a + b;
                });
        System.out.println("Reduced 4: " + reducedParallel);
    }
}
