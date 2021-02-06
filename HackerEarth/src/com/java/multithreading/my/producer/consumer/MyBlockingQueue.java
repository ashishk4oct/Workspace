package com.java.multithreading.my.producer.consumer;

import javafx.beans.value.ObservableObjectValue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {

    private Queue<E> queue = new LinkedList<>();
    private int max;
    private Object notEmpty = new Object();
    private Object notFull = new Object();

    public MyBlockingQueue(int size) {
        this.max = size;
    }

    public synchronized void put(E element) throws InterruptedException {
        while (queue.size() == max) {
            synchronized (notFull){
                notFull.wait(); // wait for not empty to be triggered
            }
        }
        queue.add(element);
        synchronized (notEmpty){
            notEmpty.notifyAll();
        }
    }

    public synchronized E take() throws InterruptedException {
        while (queue.size() == 0) {
            synchronized (notEmpty) {
                notEmpty.wait(); // wait for not full to be triggered
            }
        }
        E element = queue.remove();
        synchronized (notFull) {
            notFull.notifyAll();
        }
        return element;
    }

}
