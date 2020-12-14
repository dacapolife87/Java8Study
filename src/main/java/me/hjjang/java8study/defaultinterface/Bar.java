package me.hjjang.java8study.defaultinterface;

public interface Bar extends Foo {
    
    // Foo에 있는 메소드를 사용하기 싫을 경우
    void printNameUpperCase();
}
