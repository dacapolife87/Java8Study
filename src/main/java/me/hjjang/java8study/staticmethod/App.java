package me.hjjang.java8study.staticmethod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("hjjang");
        names.add("eunjung");
        names.add("jinwoo");
        names.add("hayang");
        names.add("creamy");

        names.forEach( s -> System.out.println(s));
        System.out.println("=============================");
        names.forEach( System.out::println);
        System.out.println("=============================");
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("=============================");
        Spliterator<String> spliterator = names.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("===========");
        while (spliterator1.tryAdvance(System.out::println));
        System.out.println("=============================");

        long count = names.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("H"))
                .count();
        System.out.println(count);
        List<String> stringList = names.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("h"))
                .collect(Collectors.toList());

        names.removeIf(s -> s.startsWith("h"));

        names.forEach(System.out::println);

        System.out.println("********************");
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.forEach(System.out::println);
        System.out.println("********************");
        names.sort(compareToIgnoreCase);
        names.forEach(System.out::println);
        System.out.println("********************");
        names.sort(compareToIgnoreCase.reversed());
        names.forEach(System.out::println);

//        names.sort(compareToIgnoreCase.reversed().thenComparing());
    }
}
