package bankapp;

public class Account {
	private int balance;
	
	public Account(int balance) {
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}
	
	synchronized public void withdraw(int amount) {
		System.out.println(this.balance + " Check balance by: " + Thread.currentThread().getName());
		this.balance = balance-amount;
		System.out.println(this.balance +" Check balance by: " + Thread.currentThread().getName());
	}
	
	synchronized public void deposit(int amount) {
		System.out.println(this.balance + " Check balance by: " + Thread.currentThread().getName());
		this.balance = balance+amount;
		System.out.println(this.balance + " Check balance by: " + Thread.currentThread().getName());
	}
	
}
