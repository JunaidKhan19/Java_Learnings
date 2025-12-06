package locksinmultithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
	private final Lock lock = new ReentrantLock(true); //true is for fairness of lock
	
	private int balance = 100;
	
	public void withdraw(int amount) {
		System.out.println(Thread.currentThread().getName() + " trying to withdraw " + amount);
		try {
			if(lock.tryLock(3000, TimeUnit.MILLISECONDS)) {
				System.out.println(Thread.currentThread().getName() + " acquired the lock");
				if (balance >= amount) {
					try {
						System.out.println(Thread.currentThread().getName() + " processing to withdraw " + amount);
						Thread.sleep(1500);
						balance -= amount ;
						System.out.println(Thread.currentThread().getName() + " successfully withdraw " + amount);
						System.out.println(Thread.currentThread().getName() + " current balance = " + balance);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						System.out.println(Thread.currentThread().getName() + " releasing the lock");
						lock.unlock();
					}
				} else {
					System.out.println("insufficient balance");
				}
			} else {
				System.out.println(Thread.currentThread().getName() + " could not aqcuire the lock");
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public void deposit(int amount) {
		System.out.println(Thread.currentThread().getName() + " trying to deposit " + amount);
		try {
			lock.lockInterruptibly();
			if (amount >= 0) {
				try {
					System.out.println(Thread.currentThread().getName() + " processing to deposit " + amount);
					Thread.sleep(2000);
					balance += amount ;
					System.out.println(Thread.currentThread().getName() + " successfully deposited " + amount);
					System.out.println(Thread.currentThread().getName() + " current balance = " + balance);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					System.out.println(Thread.currentThread().getName() + " releasing the lock");
					lock.unlock();
				}
			} else {
				System.out.println("enter amount greater than zero");
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}
}
