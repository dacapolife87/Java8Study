package me.hjjang.java8study.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("hjjang");
        names.add("eunjung");
        names.add("jinwoo");
        names.add("hayang");
        names.add("creamy");

        Stream<String> stream = names.stream().map(String::toUpperCase);

        List<String> collect = names.stream().map(s -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());

        collect.forEach(System.out::println);
        System.out.println("=========================");

        names.forEach(System.out::println);

        List<String> collect1 = names.parallelStream().map(s -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect1.forEach(System.out::println);

        List<String> collect2 = names.stream().map(s -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect2.forEach(System.out::println);

    }
}
