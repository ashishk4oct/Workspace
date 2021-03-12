package com.java.multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        //task to run after 3 seconds of delay
        service.schedule(new Task(), 3, TimeUnit.SECONDS);

        // task to run repeatedly after every 3 seconds
        service.scheduleAtFixedRate(new Task(),5 ,3, TimeUnit.SECONDS);

        // task to run repeatedly 4 seconds after previous task completes
        service.scheduleWithFixedDelay(new Task(),1 ,4, TimeUnit.SECONDS);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();

    }
}
