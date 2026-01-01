package com.test.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.benmanes.caffeine.cache.Scheduler;
import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.*;

public class CaffeineCacheImpl {

    static class IWeightedRoundRobinStrategy{
        public static boolean hasExpired() {
            return false;
        }
    }
    public static void main(String[] args) throws InterruptedException {

//        Map<String, IWeightedRoundRobinStrategy> map = new ConcurrentHashMap<>();
//        Cache<String, IWeightedRoundRobinStrategy> cache = Caffeine.newBuilder()
//                .expireAfterWrite(Duration.ofMinutes(30))
//                .removalListener((key, value, cause) -> {
//                    map.compute((String.valueOf(key)), (k, v) -> {
//                        if(v.hasExpired()){
//                            return null;
//                        }
//                        return v;
//                    });
//                }).build();
//
//
//
//        int v = 7;
//        Double d = (double) v / 100;
//        System.out.println(d);
//        System.out.println("CaffeineCacheImpl: start");

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(r-> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            t.setName("CaffeineCacheImpl");
            return t;
        });
        Instant start1 = Instant.now();

        LoadingCache<String, String> loadingCache = Caffeine.newBuilder().
                refreshAfterWrite(10, TimeUnit.SECONDS).
                expireAfterAccess(20, TimeUnit.SECONDS).
//                scheduler(Scheduler.forScheduledExecutorService(executor)).
                removalListener((key, value, cause) -> { // happens everytime
                    System.out.println("CaffeineCacheImpl: removal from cache: " + key +" time: "+ (Instant.now().toEpochMilli()-start1.toEpochMilli()));
                }).
                build((id) -> buildWeightedRoundRobinStrategy(id));

        Runtime.getRuntime().addShutdownHook(buildShutdownHook(executor, 5));

        Instant start = Instant.now();
        String id = loadingCache.get("test1");
        System.out.println(id+" "+Instant.now().toString());
        while(id.equals(loadingCache.get("test1"))){
            if(start.plus(Duration.ofSeconds(5)).isBefore(Instant.now())){
                loadingCache.invalidate("test1");
            }
        }
        id = loadingCache.get("test1");
        System.out.println(id+" "+Instant.now().toString());
        while(id.equals(loadingCache.get("test1"))){
        }
        Instant end = Instant.now();
        System.out.println((end.toEpochMilli()-start.toEpochMilli()));
//        loadingCache.invalidateAll();
        System.out.println("CaffeineCacheImpl: end");

        loadingCache.invalidateAll();
        loadingCache.cleanUp();
    }

    private static String buildWeightedRoundRobinStrategy(String id) throws InterruptedException {
        System.out.print("buildWeightedRoundRobinStrategy: " + id);
        sleep("buildWeightedRoundRobinStrategy: ", 2);
        return id + "#" + (int)(Math.random()*100);
    }

    public static void sleep(int seconds) throws InterruptedException {
        sleep(null, seconds);
    }

    public static void sleep(String msg, int seconds) throws InterruptedException {
        String str = (msg == null?"":msg) +" Sleep " + seconds + " seconds " + (int)(Math.random()*100);
        System.out.println();
        System.out.println(str + ": start");
        Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        System.out.println(str + ": stop");
    }


    public static Thread buildShutdownHook(ExecutorService executor, int timeoutSeconds) {
        return new Thread(() -> {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(timeoutSeconds, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        });
    }
}
