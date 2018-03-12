package com.java.paraller.data.processing;

import java.util.concurrent.RecursiveTask;

@SuppressWarnings("serial")
public class ForkJoinSumCalculator extends RecursiveTask<Long>{

	private final long[] numbers;
	private final int start;
	private final int end;
	
	public static long THRESHOLD = 10000;
	
	public ForkJoinSumCalculator(long[] numbers) {
		this(numbers, 0, numbers.length);
	}
	
	private ForkJoinSumCalculator(long[] numbers, int start, int end) {
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Long compute() {
		int length = end - start;
		if(length <= THRESHOLD) {
			return computeSequentially();
		}
		
		ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start+length/2);
		leftTask.fork();
		
		ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start+length/2, end);
		
		Long rightResult = rightTask.compute();
		Long leftResult = leftTask.join();
		return rightResult + leftResult ;
	}

	private Long computeSequentially() {
		long sum = 0;
		for (int i = start; i < end ; i++) {
			sum += numbers[i];
		}
		return sum;
	}

}