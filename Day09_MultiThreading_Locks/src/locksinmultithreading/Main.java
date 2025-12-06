package locksinmultithreading;

import java.util.Iterator;

public class Main{
    public static void main(String[] args) {
    	Bank boi = new Bank();
    	
    //used trylock with timed waiting to acquire the lock
        Thread customer1 = new Thread(new Runnable() {
			@Override
			public void run() {
				boi.withdraw(20);
			}
		}, "Customer 1" );
        
        Thread customer2 = new Thread(new Runnable() {
			@Override
			public void run() {
				boi.withdraw(50);
			}
		}, "Customer 2" );
        
        customer1.start();
        customer2.start();
        
        //used  lockInterruptibly so that threads that are waiting can be interrupted
        Thread customer3 = new Thread(() -> boi.deposit(100), "Customer 3");
        Thread customer4 = new Thread(() -> boi.deposit(50), "Customer 4");

        customer3.start();

        // Give customer1 time to acquire the lock first
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        customer4.start();

        // Interrupt customer4 after 1 second
        try {
            Thread.sleep(2000);
            System.out.println("Interrupting Customer 4");
            customer4.interrupt();
            System.out.println("successsfully Interrupted Customer 4");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    	
    //Read write locks demonstration
    	Counter counter = new Counter();
    	
    	Runnable readCount = new Runnable() {
    		@Override
    		public void run() {
    			for(int i = 0; i < 10; i++) {
    				System.out.println(Thread.currentThread().getName() + " reading " + counter.getCount());
    			};
    		}
    	};
    	
    	Runnable writeCount = new Runnable() {
    		@Override
    		public void run() {
    			for(int i = 0; i <= 10; i++) {
    				counter.increment();
    				System.out.println(Thread.currentThread().getName() + " writing thread counter incremented ");
    			};
    		}
    	};
    	
    	Thread writerThread = new Thread(writeCount,"Writer");
    	Thread readerThread1 = new Thread(readCount, "R1");
    	Thread readerThread2 = new Thread(readCount, "R2");
    	
    	writerThread.start();
    	readerThread1.start();
    	readerThread2.start();
    	
    	try {
    		writerThread.join();
        	readerThread1.join();
			readerThread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	System.out.println("Final count = " + counter.getCount());

    	

    //Lambda expression: implement anonymous function using (->) to reduce size of code
    	//traditional way : anonymous inner class where the abstract method of interface is implemented directly without name
    	LambdaExpressionExample student = new LambdaExpressionExample() {
			@Override
			public String printName(String name) {
				return name + " is students name.";			
			}
		};
		
		String jhon = student.printName("Jhon");
		System.out.println(jhon);
		
		//using lambda expression: the function of the interface is used here directly without function name 
		LambdaExpressionExample student1 = name -> name + " is students name."; 
		
		String tesla = student1.printName("Tesla");
		System.out.println(tesla);
		
		//we can also take the above bank example threads using lambda expression
		Thread t1 = new Thread(() -> boi.withdraw(50), "T-1");
		t1.start();
	}  
}