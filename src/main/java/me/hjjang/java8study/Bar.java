package me.hjjang.java8study;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Bar {

    public static void main(String[] args) {
        Bar bar = new Bar();
        bar.run();
    }

    private void run() {

        // 자바 8부터는 final 생략 가능
        // 해당 변수가 사실상 final인 경우 -> 변수가 변경되게되면 컴파일 에러
//        final int baseNumber = 10;
        int baseNumber = 10;

        // 로컬 클래스
        class LocalClass {

            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber); // 11
            }
        }

        // 익명클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber);
            }
        };

        // 람다
        // 같은 scope 안에 같은 변수를 선언할수가 없음
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);

//        baseNumber++;
    }

}
