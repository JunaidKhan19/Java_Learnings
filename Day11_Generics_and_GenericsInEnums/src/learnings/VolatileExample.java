package learnings;

class SharedObject{
	private boolean flag = false;
	
	public void setFlagTrue() {
		flag = true;
	}
	
	public void printFlagTrue() {
		while (!flag) {
			System.out.println("flag is false");
		}
		System.out.println("flag is true");
	}
}

public class VolatileExample {
	SharedObject sharedObj = new SharedObject();
	
	Thread writerThread = new Thread(() -> {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
		sharedObj.setFlagTrue();
	});
	
	Thread readerThread = new Thread(() -> {
		sharedObj.printFlagTrue();
	});
	
}
