package me.hjjang.java8study;

import java.util.function.Function;

public class Foo {

    public static void main(String[] args) {

        // 익명 내부 클래스
//        RunSomething runSomething = new RunSomething() {
//            @Override
//            public void doIt() {
//                System.out.println("hello World!!");
//            }
//        };

        // 람다표현식
        RunSomething runSomething = () -> System.out.println("hello World!!");
        runSomething.doIt();

        RunSomething runAnotherSomething = () -> {
            System.out.println("Hello!!!!");
            System.out.println("World!!!!!");
        };
        runAnotherSomething.doIt();

        ReturnSomething returnSomething = (number) -> number + 10;

        System.out.println(returnSomething.doIt(1));
        System.out.println(returnSomething.doIt(1));

        System.out.println(returnSomething.doIt(2));
        System.out.println(returnSomething.doIt(2));

        final int baseNumber = 10;
        ReturnSomething returnAnotherSomething = new ReturnSomething() {
//            int baseNumber = 10;

            @Override
            public int doIt(int number) {
//                baseNumber++;
                return number + baseNumber;
            }
        };
    }
}
