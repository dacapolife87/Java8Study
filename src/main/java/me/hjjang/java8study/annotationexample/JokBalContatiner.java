package me.hjjang.java8study.annotationexample;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
public @interface JokBalContatiner {

    JokBal[] value();
}
