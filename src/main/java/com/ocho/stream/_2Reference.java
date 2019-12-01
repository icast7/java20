package com.ocho.stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Java 8 streams can't be reused.
public class _2Reference {
    public static void main(String[] args) {
        List<String> elements = Stream.of("a","b","c").filter(e-> e.contains("b")).collect(Collectors.toList());
        Optional<String> anyElement = elements.stream().findAny();
        System.out.println("Any: " + anyElement.orElse("<not found>"));
        Optional<String> firstElement = elements.stream().findFirst();
        System.out.println("First: " + firstElement.get());
    }
}
