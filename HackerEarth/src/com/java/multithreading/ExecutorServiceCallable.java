package com.java.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

public class ExecutorServiceCallable {
    public static void main(String[] args) {

        ExecutorService es = Executors.newCachedThreadPool();
        Queue<Future<String>> allFutures = new LinkedList<>();
        for (int i = 0; i < 10 ; i++) {
            allFutures.add(es.submit(new MyCallable()));
        }
        es.shutdown();

        while(!allFutures.isEmpty()){
            Future<String> future = allFutures.poll();
            try {
                if(future.isDone()){
                    System.out.println("Result of future "+future.get()); // blocking operation
                }else{
                    Thread.sleep(20);
                    allFutures.add(future);
                }
            } catch (ExecutionException  e) {
                if(e.getCause() instanceof  RuntimeException){
                    RuntimeException re = (RuntimeException)e.getCause();
                    System.out.println(re.getMessage());
                }else {
                    e.printStackTrace();
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
//            System.out.println("Name: "+ Thread.currentThread().getName()+" Time:"+  new Date());
            int num = (int)(Math.random()*10);
            System.out.println("Timeout "+num);
            Thread.sleep(num*1000);
            if(num%4
                    == 0){
                throw new RuntimeException("Executed in unlucky time: "+num+" seconds");
            }
            return num+"";
        }
    }
}

