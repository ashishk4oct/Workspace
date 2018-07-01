package com.java.thread.mypool;

public class Test {

	
	
	private static int count = 1;

	public static void main(String[] args) {

		int processors = Runtime.getRuntime().availableProcessors();
		System.out.println("Avalible Processors : "+ processors);
		ThreadPool tp = new ThreadPool(processors);

		for (int j = 0; j < 10; j++) {

			Runnable runnable = () -> {
				int c = count++;
				for (int i = 1; i <= 3; i++) {
					System.out.println(c+": "+i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Done : "+c);
			};
			tp.execute(runnable);
		}
		
//		tp.shutdown();
	}

}
