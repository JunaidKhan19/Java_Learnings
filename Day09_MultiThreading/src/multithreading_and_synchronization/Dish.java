package multithreading_and_synchronization;

public class Dish {
    private String dishName;
    private boolean orderPlaced = false;
    private boolean isPrepared = false;

    // Called by Customer to place the order
    public synchronized void setOrder(String dishName) {
        System.out.println(Thread.currentThread().getName() + " is trying to place an order...");
        while (orderPlaced) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting (order already placed).");
                wait(); // Wait if an order is already placed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " got access to place the order.");
        this.dishName = dishName;
        orderPlaced = true;
        System.out.println("Customer ordered: " + dishName);
        notifyAll(); // Notify chef
        System.out.println(Thread.currentThread().getName() + " finished placing the order.\n");
    }

    // Called by Chef to prepare the dish
    public synchronized void prepareDish() {
        System.out.println(Thread.currentThread().getName() + " is ready to prepare the dish...");
        while (!orderPlaced || isPrepared) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting (no new order or already prepared).");
                wait(); // Wait if no order or already prepared
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " got access to prepare the dish.");
        System.out.println(Thread.currentThread().getName() + " is preparing: " + dishName);
        try {
            Thread.sleep(2000); // Simulate cooking
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isPrepared = true;
        System.out.println(dishName + " is prepared by " + Thread.currentThread().getName());
        notifyAll(); // Notify waiter
        System.out.println(Thread.currentThread().getName() + " finished preparing the dish.\n");
    }

    // Called by Waiter to serve the dish
    public synchronized String serveDish() {
        while (!isPrepared) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting (dish not ready).");
                wait(); // Wait until the dish is prepared
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " got access to serve the dish.");
        isPrepared = false;
        orderPlaced = false;
        System.out.println(Thread.currentThread().getName() + " served " + dishName + " to customer.");
        notifyAll(); // Allow customer to order next dish
        System.out.println(Thread.currentThread().getName() + " finished serving the dish.\n");
        return dishName;
    }
}
