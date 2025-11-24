package bankingapp;

public class Persons extends Bank implements Utils{
	
	@Override
	public void method() {
		// this is method from the interface person
		System.out.println("hello " + this.getName() );
	};
	
	public Persons(String name, int accNumber, int balance) {
		setName(name);
		setAccNumber(accNumber);
		setBalance(balance);
	}
	
	public void displayInfo() {
		System.out.println("Name: " + getName());
        System.out.println("Account Number: " + getAccNumber());
        System.out.println("Balance: " + getBalance());
        System.out.println("Loan: " + getLoan());
	}
	
	public void deposition(int amount) {
		if(amount > 0) {
			int newBalance = deposit(amount);
			System.out.println("Rs." + amount + " deposited");
			System.out.println("Current balance: " + newBalance);
		} else if (amount <= 0) {
			System.out.println("NO MONEY DEPOSITED...");
			System.out.println("PLEASE ENTER AMOUNT GREATER THAN ZERO");
			System.out.println("Current balance: " + getBalance());
		}
	}
	
	public void withdrawal(int amount) {
		if(amount > getBalance()) {
			System.out.println("NO MONEY WITHDRAWN...");
			System.out.println("Insufficient balance");
			System.out.println("Current balance: " + getBalance());
		} else if(amount <= getBalance()) {
			int newBalance = withdraw(amount);
			System.out.println("Rs." + amount + " withdrawn");
			System.out.println("Current balance: " + newBalance);
		}
	}

	@Override
	protected void getLoanOfAmount(int amount) {
		setLoan(amount);
		System.out.println(getName() + " has been sanctioned the loan of amount " + getLoan());
	}

}
