package me.hjjang.java8study.concurrent;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        invokeAllExample();
        invokeAnyExample();
    }

    private static void invokeAllExample() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println(LocalDateTime.now());
        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "Java";
        };

        Callable<String> hjjang = () -> {
            Thread.sleep(1000L);
            return "hjjang";
        };

        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, hjjang));

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        System.out.println(LocalDateTime.now());
        executorService.shutdown();
    }

    private static void invokeAnyExample() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        System.out.println(LocalDateTime.now());
        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "Java";
        };

        Callable<String> hjjang = () -> {
            Thread.sleep(1000L);
            return "hjjang";
        };

        String s = executorService.invokeAny(Arrays.asList(hello, java, hjjang));

        System.out.println(s);

        System.out.println(LocalDateTime.now());
        executorService.shutdown();
    }

}
