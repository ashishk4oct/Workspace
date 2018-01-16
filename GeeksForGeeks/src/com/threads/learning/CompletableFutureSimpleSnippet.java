package com.threads.learning;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureSimpleSnippet {

	/*public static void main(String[] args) {

		long started = System.currentTimeMillis();

		CompletableFuture<Integer> futureCount = createCompletableFuture();
		 // continue to do other work
        System.out.println("Took " + (started - System.currentTimeMillis()) + " milliseconds" );

        // now its time to get the result
        try {
          int count = futureCount.get();
            System.out.println("CompletableFuture took " + (started - System.currentTimeMillis()) + " milliseconds" );

           System.out.println("Result " + count);
         } catch (InterruptedException | ExecutionException ex) {
            // Exceptions from the future should be handled here
        }

	}*/

	public static void main(String[] args) {

		long started = System.currentTimeMillis();
        CompletableFuture<String>  data = createCompletableFuture()
                .thenApply((Integer count) -> {
                    int transformedValue = count * 10;
                    return transformedValue;
                }).thenApply(transformed -> "Finally creates a string: " + transformed);

            try {
                System.out.println(data.get());
            } catch (InterruptedException | ExecutionException e) {

            }
	}
	private static CompletableFuture<Integer> createCompletableFuture() {
        CompletableFuture<Integer> futureCount = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        // simulate long running task
                    	System.out.println("Started");
                        Thread.sleep(5000);
                        System.out.println("Done");
                    } catch (InterruptedException e) { }
                    return 20;
                });
        return futureCount;
    }
}
