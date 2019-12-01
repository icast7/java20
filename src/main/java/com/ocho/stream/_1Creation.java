package com.ocho.stream;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class _1Creation {
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

    static IntStream intStream = IntStream.range(1, 3);
    static  LongStream longClosedStream = LongStream.rangeClosed(1, 5);

    static Random random = new Random();
    static DoubleStream doubleStream = random.doubles(3);

    static IntStream streamOfChars = "abcdef".chars();

    static Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("a, b, c");

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println("Generated stream:::");
        streamGenerated.forEach(System.out::println);

        System.out.println("Iterated stream:::");
        streamIterated.forEach(System.out::println);

        System.out.println("Int Range:");
        intStream.forEach(System.out::println);

        System.out.println("Long Range Closed: " +
                longClosedStream.mapToObj(e -> Long.toString(e))
                        .reduce(", ", String::concat));

        System.out.println("Double Random Stream: " +
                doubleStream.mapToObj(e-> Double.toString(e))
                        .reduce("", (s1, s2) -> s1 + s2 + " "));

        System.out.println("IntStream from chars:");
        streamOfChars.forEach(System.out::println);

        System.out.println("Stream of Strings: " + streamOfString.reduce("",(s1, s2) -> s1 + s2 + ", "));

        URL resource = _1Creation.class.getClassLoader().getResource("myfile.txt");
        Path path = Paths.get(resource.toURI());
        Stream<String> streamOfStrings = Files.lines(path);
        System.out.println("Stream from file:");
        streamOfStrings.forEach(System.out::print);
        System.out.println("Stream from file with charset:");
        Stream<String> streamOfStringsWithCharSet = Files.lines(path, Charset.forName("UTF-8"));
        streamOfStringsWithCharSet.forEach(System.out::print);
    }
}
