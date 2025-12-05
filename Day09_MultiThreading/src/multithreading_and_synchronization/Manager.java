package multithreading_and_synchronization;

public class Manager extends Thread {
	public Manager(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("I am the manager of hotel");
	}
}
