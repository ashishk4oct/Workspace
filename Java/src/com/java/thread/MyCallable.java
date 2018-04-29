package com.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable {

	public static void main(String[] args) {

		Callable<Integer> callable = new CallableTest(-1);
		
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<Integer> future = es.submit(callable);
		
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			Throwable t  = e.getCause();
			System.out.println(t.getMessage());
		} 
		
		System.out.println("Done");
	}

	static class CallableTest implements Callable<Integer>{

		private int index;
		
		public CallableTest(int index) {
			this.index = index;
		}
		
		@Override
		public Integer call() throws Exception {
			
			if(index < 0)
				throw new Exception("index less than -1");
			
			return index;
		}
		
	}
}
