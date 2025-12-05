package multithreading_and_synchronization;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		/*making of thread
		//1. making thread by extending thread class
		Manager manager = new Manager();
		manager.start();
		
		//2. making thread by implementing Runnable interface 
		//way 1
		Receptionist receptionist = new Receptionist();
		Thread t1 = new Thread(receptionist);
		t1.start();
		// way 2
		Thread receptionist = new Thread(new Receptionist(), "thread-1")
		
		//Thread waiting
		//Thread.sleep()
		//using sleep after creating instance
		Employee employee = new Employee();
		try {
			employee.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		employee.start();
		
		//Thread life-cycles
		//using sleep in the class itself
		Customer customer = new Customer();
		customer.start();
		System.out.println(customer.getState());//learning the life-cycle of threads
		Thread.sleep(1000);
		System.out.println(customer.getState());
		customer.join();
		System.out.println(customer.getState());
		
		//setting priority
		manager.setPriority(Thread.NORM_PRIORITY);
		t1.setPriority(Thread.NORM_PRIORITY);
		employee.setPriority(Thread.MAX_PRIORITY);
		customer.setPriority(Thread.MAX_PRIORITY);
		*/
		
		//Synchronization
		Thread cleaner = new Thread(new Cleaner(), "cleaner");
		cleaner.setDaemon(true);
		cleaner.start();
		
		Manager manager = new Manager("Mngr Luffy");
		
		Receptionist receptionist = new Receptionist("Guddu");
		Thread t1 = new Thread(receptionist);
		Thread receptionist1 = new Thread(new Receptionist("Guddu"));
		
		Dish sharedDish = new Dish(); //Shared object
		Scanner sc = new Scanner(System.in);
		
		Customer customer1 = new Customer("Nico Robin", sharedDish, sc);
		Customer customer2 = new Customer("Nami", sharedDish, sc);
		Customer customer3 = new Customer("Chopper", sharedDish, sc);
		Waiter waiter = new Waiter("Usopp", sharedDish);
		Chef chef = new Chef("Sanji san", sharedDish);
		
        try {         
            manager.start();
            manager.join();            

            t1.start();
            t1.join();
            
            chef.start();   // Chef keeps waiting until a dish is ordered
            waiter.start(); // Waiter waits until dish is prepared

            // Start customers one after another
            customer1.start();
            receptionist1.start();
            customer1.join();  // Wait till customer1 finishes ordering

            customer2.start();
            receptionist1.start();
            customer2.join();  // Wait till customer2 finishes ordering

            customer3.start();
            receptionist1.start();
            customer3.join();  // Wait till customer3 finishes ordering

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

	}

}
