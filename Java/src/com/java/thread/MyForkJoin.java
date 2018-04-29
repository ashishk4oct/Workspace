package com.java.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class MyForkJoin {

	public static void main(String[] args) {

		ForkJoinPool fjp = ForkJoinPool.commonPool();
		
		ForkJoinTask<Void> task = new RecursiveAction() {
			@Override
			protected void compute() {
				System.out.println("Recursive Action");
			}
		};
		
		ForkJoinTask<String> task1 = new RecursiveTask<String>() {
			@Override
			protected String compute() {
				System.out.println("Recursive Task");
				return "Recursive Task";
			}
		};
		
		
		fjp.execute(task);

		fjp.execute(task1);
		
	}

}
