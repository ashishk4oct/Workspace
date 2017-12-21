package com.threads.learning;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/*
	So the conclusion this activity is as follows :
		1. Callable makes asynchronous calls.
		2. future.get which returns the output of the thread execution and 
			stops the main thread until callable thread completes its execution.(which makes it synchronous call)
*/
public class TestCallable {
	public static void main(String[] args) throws Exception{
		MyCallable callable = new MyCallable();
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Integer> future = executor.submit(callable);// thread starts execution
		Thread callback = new Thread(new MyRunnableCallback(future));
		callback.start();
		Thread.sleep(2000);
		System.out.println("Main :   "+(System.currentTimeMillis()));
		//System.out.println("Main get "+future.get());//Main thread waits for the execution of thread to compete and then proceeds 
		System.out.println("Main :   "+(System.currentTimeMillis()));
		executor.shutdown();
	}
}
class MyCallable implements Callable<Integer>{
	@Override
	public Integer call() throws Exception {
		System.out.println("Thread : "+System.currentTimeMillis());
		Thread.sleep(15000);
		System.out.println("Thread : "+System.currentTimeMillis());
		return 1;
	}
}
class MyRunnableCallback implements Runnable{
	private Future<Integer> future ;
	MyRunnableCallback(Future<Integer> future){
		this.future = future;
	}
	@Override
	public void run() {
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}