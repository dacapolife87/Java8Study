package me.hjjang.java8study;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<Integer> printT = (i) -> System.out.println(i);

        printT.accept(10);
    }
}
