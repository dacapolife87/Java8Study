package me.hjjang.java8study.methodref;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {
        Greeting greeting = new Greeting();
        UnaryOperator<String> hi1 = greeting::hello;

        UnaryOperator<String> hi2 = Greeting::hi;
        System.out.println(hi1.apply("hJJANG"));
        System.out.println(hi2.apply("hJJANG"));

        Supplier<Greeting> hi3 = Greeting::new;
        System.out.println(hi3.get().hello("hJJANG"));

        Function<String, Greeting> hi4 = Greeting::new;
        Greeting hJJANG = hi4.apply("hJJANG");
        System.out.println(hJJANG.getName());

        String[] names = {"hjjang", "eunjung", "jinwoo"};
        Arrays.sort(names, String::compareToIgnoreCase);

        System.out.println(Arrays.toString(names));
    }
}
