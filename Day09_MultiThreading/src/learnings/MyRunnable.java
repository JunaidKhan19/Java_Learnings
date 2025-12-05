package learnings;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is running");		
	}
	
	public static void main(String[] args) {
		MyRunnable r = new MyRunnable();

		Thread t = new Thread(r);
		t.setName("T");
		t.start();
		
		Thread t1 = new Thread(() -> System.out.println("T1 is running"));
		t1.start();
	}

}
