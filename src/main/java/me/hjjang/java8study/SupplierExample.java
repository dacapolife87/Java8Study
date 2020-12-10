package me.hjjang.java8study;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {

        Supplier<Integer> get10 = () -> 10;

        System.out.println(get10.get());
    }
}
