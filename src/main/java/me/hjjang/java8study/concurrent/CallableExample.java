package me.hjjang.java8study.concurrent;

import java.util.concurrent.*;

public class CallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "hello";
        };

        Future<String> helloFuture = executorService.submit(hello);

        System.out.println(helloFuture.isDone());
        System.out.println("Started!!");
        helloFuture.cancel(true);
        if(!helloFuture.isCancelled()) {
            helloFuture.get();  //  블록킹 콜
        }

        System.out.println(helloFuture.isDone());
        System.out.println("End!!!");
        executorService.shutdown();
    }

}
