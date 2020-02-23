package com.geeks.threads.blockingqueue;

import java.util.concurrent.*;

public class BlockingQueueTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("BlockingQueueTest");
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1);

        FutureTask<String> futureTask = new FutureTask<>(new Producer(blockingQueue));
        Thread t = new Thread(futureTask, "producer 1");
        t.start();

        FutureTask<String> futureTask1 = new FutureTask<>(new Consumer(blockingQueue));
        Thread t2 = new Thread(futureTask1);
        t2.start();

        FutureTask<String> futureTask2 = new FutureTask<>(new Producer(blockingQueue));
        Thread t3 = new Thread(futureTask2, "producer 2");

        t3.start();


        System.out.println(futureTask1.isDone());
        futureTask1.get();
        System.out.println(futureTask1.isDone());
        System.out.println("Done");
    }
}

class Producer implements Callable<String> {

    private BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public String call() throws Exception {

        int count = 10;
        while (count > 0) {
            count--;

            try {
                blockingQueue.add("" + count);
                System.out.println("produced: " + count);
                synchronized (blockingQueue) {
                    blockingQueue.notifyAll();
                }
            } catch (IllegalStateException e) {
                synchronized (blockingQueue) {
                    blockingQueue.wait();
                    count++;
                }
            }

        }

        return null;
    }
}


class Consumer implements Callable<String> {

    private BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public String call() throws Exception {

        int count = 20;
        while (count > 0) {
            count--;

            String s = blockingQueue.poll();

            if (null == s) {
                synchronized (blockingQueue) {
                    blockingQueue.wait();
                    count++;
                }
            } else {
                System.out.println("consumed: " + s);
                synchronized (blockingQueue) {
                    blockingQueue.notifyAll();
                }
            }

        }


        Thread.sleep(5000);
        return null;
    }
}