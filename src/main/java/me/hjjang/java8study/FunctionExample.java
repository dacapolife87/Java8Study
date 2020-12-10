package me.hjjang.java8study;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer, Integer> plus10 = (i -> i + 10);
        Function<Integer, Integer> multiply2 = (i -> i * 2);

        // compose 안에 값을 먼저하고 이후 나머지 처리
        Function<Integer, Integer> multi2AndPlus10 = plus10.compose(multiply2);
        System.out.println(multi2AndPlus10.apply(2));

        // 먼저 해당 펑션을 시작하고 그리고 이후 andThen안의값을 실행
        Function<Integer, Integer> plus10AndMul2 = plus10.andThen(multiply2);
        System.out.println(plus10AndMul2.apply(10));


        // 입출력이 같은경우
        UnaryOperator<Integer> unaryPlus10 = (i -> i + 10);
        System.out.println(unaryPlus10.apply(10));
    }
}
