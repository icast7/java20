package com.ocho.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class _6Collect {
    public static void main(String[] args) {
        List<Product> list = Arrays.asList(new Product(23, "potato"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar")
        );
        List<String> collector = list.stream().map(Product::getName).collect(Collectors.toList());
        System.out.println("String collector:");
        collector.forEach(System.out::println);

        String string = list.stream().map(Product::getName).collect(Collectors.joining(", ", "[", "]"));
        System.out.println("String: " + string);

        double avgPrice = list.stream().collect(Collectors.averagingInt(Product::getPrice));
        System.out.println("Average price: " + avgPrice);

        int priceSum = list.stream().collect(Collectors.summingInt(Product::getPrice));
        System.out.println("Sum price: " + priceSum);

        IntSummaryStatistics stats = list.stream().collect(Collectors.summarizingInt(Product::getPrice));
        System.out.println("Stats: " + stats);

        Map<Integer, List<Product>> collectorMapOfLists = list.stream().collect(Collectors.groupingBy(Product::getPrice));
        System.out.println("Map of products by price:");
        collectorMapOfLists.forEach((k, v) -> System.out.println(k + ":" + v.toString()));

        Map<Boolean, List<Product>> mapPartioned = list.stream()
                .collect(Collectors.partitioningBy(e -> e.getPrice() > 15));
        System.out.println("Map of products by price range:");
        mapPartioned.forEach((k, v) -> System.out.println(k + ":" + v.toString()));

        Set<Product> unmodifiableSet = list.stream().collect(Collectors.collectingAndThen(Collectors.toSet(),
                Collections::unmodifiableSet));
        System.out.println("Set:");
        unmodifiableSet.forEach(e -> System.out.println(e));

        Collector<Product, ?, LinkedList<Product>> toLinkedList = Collector.of(LinkedList::new, LinkedList::add,
                (first, second) -> {
                    first.addAll(second);
                    return first;
                });
        LinkedList<Product> linkedListOfProducts = list.stream().collect(toLinkedList);
        System.out.println("Custom collector ::: Linked list:");
        linkedListOfProducts.forEach(e -> System.out.println(e));

    }

    static class Product {
        private int price;
        private String name;

        public Product(int price, String name) {
            this.price = price;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return this.name + "($" + price + ")";
        }
    }
}
