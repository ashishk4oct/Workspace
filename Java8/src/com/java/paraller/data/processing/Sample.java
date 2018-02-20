package com.java.paraller.data.processing;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Sample {

	public static void main(String[] args) {

		Sample s = new Sample();
		

		System.out.printf("%-20s = %6s\n","sequentialSum", s.measureSumPerf(Sample::sequentialSum , 10000000));
		System.out.printf("%-20s = %6s\n","parallelSum", s.measureSumPerf(Sample::parallelSum , 10000000));
		System.out.printf("%-20s = %6s\n","iterativeSum", s.measureSumPerf(Sample::iterativeSum , 10000000));
		System.out.printf("%-20s = %6s\n","seq_LongStream", s.measureSumPerf(Sample::seq_LongStream , 10000000));
		System.out.printf("%-20s = %6s\n","par_LongStream", s.measureSumPerf(Sample::par_LongStream , 10000000));
		System.out.printf("%-20s = %6s\n","forkJoinSum", s.measureSumPerf(Sample::forkJoinSum , 10000000));
	}
	
	
	public long measureSumPerf(Function<Long, Long> adder, long n) {
		long fastest = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			long sum = adder.apply(n);
			long duration = (System.nanoTime() - start) / 1000;
//			System.out.println("Result: " + sum);
			if (duration < fastest)
				fastest = duration;
		}
		return fastest;
	}

	public static long sequentialSum(long n) {
		return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
	}
	public static long parallelSum(long n) {
		return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
	}
	public static long iterativeSum(long n) {
		long sum = 0;
		for (int j = 1; j <= n; j++) {
			sum += j;
		}
		return sum;
	}
	
	public static long seq_LongStream(long n) {
		return LongStream.rangeClosed(1L, n).reduce(0L, Long::sum);
	}
	
	public static long par_LongStream(long n) {
		return LongStream.rangeClosed(1L, n).parallel().reduce(0L, Long::sum);
	}
	public static long forkJoinSum(long n) {
		long[] numbers = LongStream.rangeClosed(1, n).toArray();
		ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
		return new ForkJoinPool().invoke(task);
	}
}
