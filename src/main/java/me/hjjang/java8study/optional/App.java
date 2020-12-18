package me.hjjang.java8study.optional;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();

        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        OnlineClass spring_boot = new OnlineClass(1,"springboot", true);
        // NullPointerException
//        Duration studyDuration = spring_boot.getProgress().getStudyDuration();
//        System.out.println(studyDuration);

        // 이전 예외처리 방법
//        Progress progress = spring_boot.getProgress();
//        if(progress != null) {
//            System.out.println(progress.getStudyDuration());
//        }

        // 권장안함
//        Optional.of(10); // boxing unboxing 발생
        OptionalInt.of(10);
    }
}
