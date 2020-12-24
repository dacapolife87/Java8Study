package me.hjjang.java8study.concurrent;

public class App {
    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("Hello!!" + Thread.currentThread().getName());

        Thread thread = new Thread(() -> {
            System.out.println("ThreadRunnable : "+ Thread.currentThread().getName());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });
        thread.start();

        System.out.println("Hello!!!!!");

        thread.join();
        System.out.println(thread + " is finished!");
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("Thread : "+Thread.currentThread().getName());
        }
    }
}
