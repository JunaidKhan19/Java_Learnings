package bankingapp;

public class Main {

	public static void main(String[] args) {
		Persons Joy = new Persons("JOY LOBO", 54321, 1000);
		Persons Rancho = new Persons("RANCHO", 12345, 10000);
		Joy.displayInfo();
		Rancho.displayInfo();
		
		Joy.method();//this is the method of utils implemented to person. Abstract method
		System.out.println("this is the static constant in interface Utils. MAX_BALANCE = " + Utils.MAX_BALANCE);
		Joy.run(); //this is the default method in interface Utils
		System.out.println("this is static method to find square. " + Utils.square(5));
		
		Joy.deposition(100);
		Joy.withdrawal(900);
		Joy.deposition(200);
		Joy.withdrawal(500);
		Joy.getLoanOfAmount(500);
		
	}
}
