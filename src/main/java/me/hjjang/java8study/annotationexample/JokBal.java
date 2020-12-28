package me.hjjang.java8study.annotationexample;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@Repeatable(JokBalContatiner.class)
public @interface JokBal {

    String value();
}
