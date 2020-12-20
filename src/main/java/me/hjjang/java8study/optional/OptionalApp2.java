package me.hjjang.java8study.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalApp2 {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();

        springClasses.add(new OnlineClass(1, "spring boot",true));
        springClasses.add(new OnlineClass(5, "rest api development",false));

        Optional<OnlineClass> spring = springClasses.stream()
                .filter(onlineClass -> onlineClass.getTitle().startsWith("spring"))
                .findFirst();

        Optional<Progress> progress = spring.flatMap(OnlineClass::getProgress);
        System.out.println(progress.get());

        boolean present = spring.isPresent();
        System.out.println(present);
        spring.ifPresent(onlineClass -> System.out.println(onlineClass.getTitle()));
        OnlineClass onlineClass1 = spring.orElse(createNewClasses());
        System.out.println(onlineClass1.getTitle());

        Optional<OnlineClass> jpaClass = springClasses.stream()
                .filter(onlineClass -> onlineClass.getTitle().startsWith("jpa"))
                .findFirst();


        boolean present1 = jpaClass.isPresent();
        System.out.println(present1);
    }

    private static OnlineClass createNewClasses() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New Class", false);
    }
}
