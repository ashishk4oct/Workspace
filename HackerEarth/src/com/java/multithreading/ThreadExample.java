package com.java.multithreading;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExample {
    public static void main(String[] args) {
        thread();
        executorService();
    }

    private static void executorService() {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Task());
        }
        executorService.shutdown();
    }

    public static void thread() {
        for (int i = 0; i < 10 ; i++) {
            Thread thread = new Thread(new Task(), "Thread-"+i);
            thread.start();
        }
        System.out.println("Name: "+ Thread.currentThread().getName());
    }
}
class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("Name: "+ Thread.currentThread().getName()+" Time:"+ new Date());
    }
}