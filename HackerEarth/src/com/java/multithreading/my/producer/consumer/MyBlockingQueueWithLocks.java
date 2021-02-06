package com.java.multithreading.my.producer.consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyBlockingQueueWithLocks<E> {

    private Queue<E> queue = new LinkedList<>();
    private int max ;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public MyBlockingQueueWithLocks(int size){
        this.max = size;
    }

    public void put(E element) throws InterruptedException {
        lock.lock();
        try {
            while(queue.size() == max){
                notFull.await(); // wait for not empty to be triggered
            }
            queue.add(element);
            notEmpty.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public E take() throws InterruptedException {
        lock.lock();
        try{
            while(queue.size() == 0){
                notEmpty.await(); // wait for not full to be triggered
            }
            E element = queue.remove();
            notFull.signalAll();
            return element;
        }finally {
            lock.unlock();
        }
    }

}
