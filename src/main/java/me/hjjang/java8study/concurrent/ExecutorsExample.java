package me.hjjang.java8study.concurrent;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample {

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.execute(() -> {
//            System.out.println("Thread "+ Thread.currentThread().getName());
//        });

//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.submit(getRunnable("Hello"));
//        executorService.submit(getRunnable("World"));
//        executorService.submit(getRunnable("The"));
//        executorService.submit(getRunnable("Java"));
//        executorService.submit(getRunnable("eight"));
//
//        executorService.shutdown();

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(getRunnable("Hello"),1, 2, TimeUnit.SECONDS);
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
