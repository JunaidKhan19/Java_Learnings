package bankingapp;

public interface Utils {
	//static constants
	public static final int MAX_BALANCE = 500000;
	
	//abstract method
	public abstract void method();
	
	//static method
	static int square (int number) {
		return number*number;
	}

	public static void main(String... args){
		//Note: An interface is meant to define behavior (rules/specifications) that classes must implement — not executable programs.
		//It's not recommended to have main methods in interfaces
		System.out.println("this is a utility interface");	
		
		//Can be used to quickly test static or default methods in interface itself
		System.out.println("Printing square within the interface itself: " + square(5));
	};

	//default method
	default void run() {
		System.out.println("the maximum balance should be " + MAX_BALANCE);
	}
}
