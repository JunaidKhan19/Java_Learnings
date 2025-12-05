package bankapp;

public class BankApplication {

	public static void main(String[] args) {
		//Execution of methods using threads
		
		Account a = new Account(53020);
		
		a.withdraw(2500);
		
		a.deposit(6000);
	}

}
