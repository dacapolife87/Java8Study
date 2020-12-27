package me.hjjang.java8study.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFutureExample2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello "+Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> future = hello.thenCompose(CompletableFutureExample2::getWorld);
        System.out.println(future.get());

        System.out.println("==================================");

        CompletableFuture<String> world2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("World2 "+Thread.currentThread().getName());
            return "World2";
        });

        CompletableFuture<String> future1 = hello.thenCombine(world2, (h, w) -> h + " " + w);
        System.out.println(future1.get());

        CompletableFuture<Void> future2 = CompletableFuture.allOf(hello, world2)
                .thenAccept(System.out::println);

        System.out.println(future2.get());

        List<CompletableFuture<String>> futures = Arrays.asList(hello, world2);

        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);
        CompletableFuture<List<String>> results = CompletableFuture.allOf(futuresArray)
                .thenApply(v -> {
                    return futures.stream()
                            .map(CompletableFuture::join)
                            .collect(Collectors.toList());
                });

        results.get().forEach(System.out::println);


        System.out.println("=======================");
        CompletableFuture<Void> future3 = CompletableFuture.anyOf(hello, world2).thenAccept(System.out::println);

        future3.get();

        boolean throwError = false;

        CompletableFuture<String> exceptionally = CompletableFuture.supplyAsync(() -> {

            if (throwError) {
                throw new IllegalArgumentException();
            }

            System.out.println("Hello!!!!!!!! " + Thread.currentThread().getName());
            return "Hello!!!!!!!!!!";
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "Error!!!!!!!!!!";
        });


        System.out.println(exceptionally.get());

        CompletableFuture<String> exceptionally2 = CompletableFuture.supplyAsync(() -> {

            if (throwError) {
                throw new IllegalArgumentException();
            }

            System.out.println("Hello!!!!!!!! " + Thread.currentThread().getName());
            return "Hello!!!!!!!!!!";
        }).handle((result, ex) -> {

            if(ex != null) {
                System.out.println(ex);
                return "Error!!!!!!!!!!!!";
            }

            return result;
        });

        System.out.println(exceptionally2.get());
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return message + "World";
        });
    }
}
