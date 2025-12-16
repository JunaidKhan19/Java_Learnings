package executionframeworkservices;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorInEF {

	public static void main(String[] args) {
		//ScheduledExecutorService and ScheduledFuture:
		/*
		Scheduling Methods = How the task should run
		 * once?
		 * repeatedly at fixed rate?
		 * repeatedly with delay?
		ScheduledFuture = Control object for the task
		 * get result (only for schedule-Callable)
		 * get remaining delay
		 * cancel repeating tasks
		 * check status
		*/
		//scheduler object
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
		
		//Tasks and types
		// 1. Schedule → Runs once → returns data
		ScheduledFuture<String> once = scheduler.schedule(() -> {
		    return "One time task done!";
		}, 5, TimeUnit.SECONDS);
		
		// 2. Fixed Rate → repeats → can only cancel
		//repeats periodically at fixed rate of time
		ScheduledFuture<?> fixedRate = scheduler.scheduleAtFixedRate(() -> {
		    System.out.println("Fixed rate running");
		}, 2, 3, TimeUnit.SECONDS);
		/* 2 sec → run
		 * +3 sec → run
		 * +3 sec → run
		 * (ignores task duration)
		*/
		
		// 3. Fixed Delay → repeats → can only cancel
		//repeats periodically at fixed rate but after completion of previous task
		ScheduledFuture<?> fixedDelay = scheduler.scheduleWithFixedDelay(() -> {
		    System.out.println("Fixed delay running");
		}, 3, 2, TimeUnit.SECONDS);
		/*3 sec → run  
		 * (wait until end)  
		 * +2 sec → run  
		 * (wait until end)  
		 * +2 sec → run  
		*/
		
		// Using ScheduledFuture features
		System.out.println("Remaining delay: " + once.getDelay(TimeUnit.SECONDS));

		String result = null;
		try {
			result = once.get();  // waits only for schedule()
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("Result = " + result);

		// Cancel repeating tasks after 10 seconds
		scheduler.schedule(() -> {
		    fixedRate.cancel(false);
		    fixedDelay.cancel(false);
		    scheduler.shutdown();
		}, 10, TimeUnit.SECONDS);
	}

}
