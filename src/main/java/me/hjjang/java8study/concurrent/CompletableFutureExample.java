package me.hjjang.java8study.concurrent;

import java.util.concurrent.*;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> future = new CompletableFuture<>();
//        future.complete("hjjang");
//
//        System.out.println(future.get());
//
//        CompletableFuture<String> future1 = CompletableFuture.completedFuture("hjjang");
//        System.out.println(future1.get());
//
//        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
//            System.out.println("Hello2 " + Thread.currentThread().getName());
//        });
//
//        future2.get();

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello3 " + Thread.currentThread().getName());
            return "Hello!!!";
        }).thenApply((s) -> {
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        });

        System.out.println(future3.get());

        CompletableFuture<Void> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello4 " + Thread.currentThread().getName());
            return "Hello4!!!";
        }).thenAccept((s) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });

        future4.get();

        CompletableFuture<Void> future5 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello5 " + Thread.currentThread().getName());
            return "Hello5!!!";
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        future5.get();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> future6 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello6 " + Thread.currentThread().getName());
            return "Hello6!!!";
        }, executorService).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        future6.get();
        executorService.shutdown();

        ExecutorService executorService2 = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> future7 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello7 " + Thread.currentThread().getName());
            return "Hello7!!!";
        }, executorService2).thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        }, executorService2);

        future7.get();

        executorService2.shutdown();
    }
}
