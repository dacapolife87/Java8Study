package me.hjjang.java8study.annotationexample;

import java.util.Arrays;
import java.util.List;

@Chicken
public class AnnotationApp {

    public static void main(@Chicken String[] args) throws @Chicken RuntimeException{

        List<@Chicken String> names = Arrays.asList("hJJANG");
    }

    // 사용하려는 어노테이션에 타입 파라미터가없으면 파라미터로 사용불가능
    // @Target(ElementType.TYPE_PARAMETER)
    static class FeelsLikeChicken<@Chicken T> {

        // 타입파라미터 지정시에는 리턴타입 전에 제네릭선언
        public static <@Chicken C> void print(C c) {
            System.out.println(c);

        }
    }
}
