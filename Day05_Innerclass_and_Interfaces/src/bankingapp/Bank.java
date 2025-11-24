package bankingapp;

public abstract class Bank {
	private String name;
	private int accNumber;
	private int balance;
	private int loan;
	protected abstract void getLoanOfAmount(int amount);
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAccNumber() {
		return accNumber;
	}
	
	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int getLoan() {
		return loan;
	}
	
	public void setLoan(int loan) {
		this.loan = loan;
	}
	
	protected Bank() {
		this.accNumber = 0;
		this.balance = 0;
		this.loan = 0;
		System.out.println("BASE CONSTRUCTOR CALLED");
	}
	
	protected int deposit(int depositAmount) {
		this.balance = balance + depositAmount;
		return getBalance();
	}
	
	protected int withdraw(int withdrawalAmount) {
		this.balance = balance - withdrawalAmount;
		return getBalance();
	}
}
