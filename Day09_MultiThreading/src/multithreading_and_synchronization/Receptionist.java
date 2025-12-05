package multithreading_and_synchronization;

public class Receptionist implements Runnable {
	private String name;
	public Receptionist(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println( name + " is greeting the customer");
	}
}
