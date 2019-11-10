package com.java.parallel.streams;

import com.java.paraller.data.processing.ForkJoinSumCalculator;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoinSumCalculatorTest {

    public static void main(String[] args) {

        Instant start = Instant.now();
        System.out.println(forkJoinSum(100000000));
        System.out.println(Duration.between(start,Instant.now()).toMillis());
    }

    private static long forkJoinSum(int n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }

}
