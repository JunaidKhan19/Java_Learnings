package executionframeworkservices;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorFramework {	
	private static long factorial(int n) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		long result = 1;
		for(int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
	
	public static void main(String[] args) {
  
		/*
		 * Issues with manual new Thread():
		 * Creates 9 new threads consumed lots of CPU resources → expensive
		 * Threads are not reused
		 * Scheduling overhead is high
		 * Context switching increases total time
		 * Not scalable for real systems
		*/
		long startTime = System.currentTimeMillis();
		Thread[] threads = new Thread[9];
		for(int i = 1; i < 10; i++) {
			int finalI = i;
			threads[i -1] = new Thread(() -> {
				long result = factorial(finalI);
				System.out.println(result);
			});
			threads[i -1].start();
		}
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (Exception e) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.println("Total time: " + (System.currentTimeMillis() - startTime));	
		
		
	//Executor service, .submit and .shutdown
		long startTime1 = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for(int i = 1; i < 10; i++) {
			int finalI = i;
			executor.submit(() -> {
				long result = factorial(finalI);
				System.out.println(result);
			});
		}
		executor.shutdown();
		try {
			executor.awaitTermination(5, TimeUnit.SECONDS); //this makes the main thread wait until executor has finished
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Total time: " + (System.currentTimeMillis() - startTime1));		

		
	//Cached thread pool
		ExecutorService cachedExecutor = Executors.newCachedThreadPool(); // can be used same as the fixed thread pool.
	}	
}
