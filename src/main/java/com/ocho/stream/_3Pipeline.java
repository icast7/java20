package com.ocho.stream;

import java.util.stream.Stream;

public class _3Pipeline {
    public static void main(String[] args) {
        Stream<String> onceModified = Stream.of("aaa","bbb","ccc").skip(1);
        Stream<String> onceModifiedV = Stream.of("aaa","bbb","ccc").skip(1);
        onceModifiedV.forEach(System.out::println);

        Stream<String> twiceModified = onceModified.map(e -> e.substring(0,2)).sorted();
        long length = twiceModified.sorted().count();
        System.out.println("Length: " + length);
    }
}
