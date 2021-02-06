package com.java.multithreading.my.producer.consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyProducerConsumer {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
//        MyBlockingQueue<String> blockingQueue = new MyBlockingQueue<>(10);
//        MyBlockingQueueWithLocks<String> blockingQueue = new MyBlockingQueueWithLocks<>(20);
        final Runnable producer = () -> {
            int count = 0;
            while (count++ < 10) {
                try {
                    String num = ""+(int) (Math.random() * 100);
                    System.out.println("produce " + num);
                    blockingQueue.put(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        service.submit(producer);
        service.submit(producer);

        final Runnable consumer = () -> {
            int count = 0;
            while (count++ < 10) {
                try {
                    System.out.println("------------------- consume " + blockingQueue.take());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        service.execute(consumer);
        service.execute(consumer);

        service.shutdown();

    }
}
