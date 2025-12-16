package executionframeworkservices;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureInEF {
	public static void main(String[] args) {
		//Future in executor service can:
		/*
		 * Future lets you:
		 * return the computation value 
		 * wait for any computation 
		 * help to know if task was successful.
		 * get() result
		 * isDone() check
		 * detect exceptions
		 * cancellation (future.cancel())
		 * Note : Future DOES NOT SUPPORT COMPLETION CALLBACKS
		 * For that Java uses CompletableFuture.
		*/
		ExecutorService executor1 = Executors.newSingleThreadExecutor();
		Future<Integer> future = executor1.submit(() -> 42);
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		if(future.isDone()) {
			System.out.println("Future task executed successfully");
		}
		executor1.shutdown();
	}
}
