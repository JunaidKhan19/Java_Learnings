package learnings;

public class MyThreads extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("In run of: " + Thread.currentThread().getName() );
		}
	}
	
	public static void main(String[] args) {
		MyThreads t1 = new MyThreads();
		t1.setName("Hello");
		t1.start();
		MyThreads t2 = new MyThreads();
		t2.setName("Hii");
		t2.start();
		
	}
}
