package me.hjjang.java8study;

import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {

        Predicate<String> startsWithHjjang = (s) -> s.startsWith("Hjjang");
        Predicate<Integer> isEven = (i) -> i %2 ==0;


        System.out.println(startsWithHjjang.test("Hjjang123"));
    }
}
