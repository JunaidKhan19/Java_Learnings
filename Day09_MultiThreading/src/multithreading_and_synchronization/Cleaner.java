package multithreading_and_synchronization;

public class Cleaner implements Runnable{
	@Override
	public void run() {
		while (true) {
			System.out.println("Cleaner is cleaning");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException ignored) {}
		}
	}
}
