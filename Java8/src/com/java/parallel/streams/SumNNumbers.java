package com.java.parallel.streams;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class SumNNumbers {

    public static void main(String[] args) {

        Instant start = Instant.now();
        System.out.println(sequentialSum(100000000));
        System.out.println(Duration.between(start, Instant.now()).toMillis());
        start = Instant.now();
        System.out.println(parallelSum(100000000));
        System.out.println(Duration.between(start, Instant.now()).toMillis());
        start = Instant.now();
        System.out.println(forSum(100000000));
        System.out.println(Duration.between(start, Instant.now()).toMillis());

    }


    public static long forSum(long n){
        long num = 0;
        for (long i = 1; i <= n; i++) {
            num += i;
        }
        return num;
    }
    public static long sequentialSum(long n){
        return LongStream.rangeClosed(0l,n).parallel().reduce(0l, (i,j) -> i+j);
    }
    public static long parallelSum(long n){
        return LongStream.rangeClosed(0l,n).parallel().reduce(0l, (i,j) -> i+j);
    }
}
