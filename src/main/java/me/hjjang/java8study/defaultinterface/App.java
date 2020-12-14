package me.hjjang.java8study.defaultinterface;

public class App {
    public static void main(String[] args) {
        Foo foo = new DefaultFoo("hjjang");

        foo.printName();
        foo.printNameUpperCase();
    }
}
