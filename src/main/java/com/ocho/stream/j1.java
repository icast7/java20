package com.ocho.stream;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class j1 {
    Stream<String> stringEmpty = Stream.empty();

    public Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }

    Collection<String> collection = Arrays.asList("a", "b", "c");
    Stream<String> streamOfCollection = collection.stream();

    Stream<String> streamOfArray = Stream.of("a", "b", "c");
    String[] array = new String[]{"a", "b", "c"};
    Stream<String> streamOfArrayFull = Arrays.stream(array);
    Stream<String> streamOfPartialArray = Arrays.stream(array, 1,2);

    Stream<String> streamBuilder = Stream.<String>builder().add("a").add("z").add("n").build();

    static Stream<String> streamGenerated = Stream.generate(() -> "ok").limit(3);

    static  Stream<Integer> streamIterated = Stream.iterate(10, n -> n+2).limit(3);

    IntStream intStream = IntStream.range(1, 3);
    LongStream longStream = LongStream.rangeClosed(1, 5);

    Random random = new Random();
    DoubleStream doubleStream = random.doubles(3);
    //https://www.baeldung.com/java-8-streams

    public static void main(String[] args) {
        System.out.println("Generated stream:::");
        streamGenerated.forEach(System.out::println);

        System.out.println("Iterated stream:::");
        streamIterated.forEach(System.out::println);
    }
}
