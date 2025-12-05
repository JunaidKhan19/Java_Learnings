package multithreading_and_synchronization;

import java.util.Scanner;

public class Customer extends Thread {
	private String name;
	private Scanner scanner;
	private Dish sharedDish;
	
	public Customer(String name, Dish dish, Scanner scanner) {
		this.name = name;
		this.sharedDish = dish;
		this.scanner = scanner;
		setName(name);
	}
	
	@Override
	public void run() {
		System.out.println( name + " has entered the restaurant and wants to place an order.");
        System.out.println(name + ": Enter the dish you want to order:");
        String dishName = scanner.nextLine();
        sharedDish.setOrder(dishName);
		System.out.println("customer has placed order for " + dishName);
	}
}