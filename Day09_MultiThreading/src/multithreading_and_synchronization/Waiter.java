package multithreading_and_synchronization;

public class Waiter extends Thread {
    private String name;
    private Dish sharedDish;

    public Waiter(String name, Dish dish) {
        this.name = name;
        this.sharedDish = dish;
        setName(name);
    }

    @Override
    public void run() {
        System.out.println(name + " is taking orders.");
        while (true) {
            sharedDish.serveDish();
        }
    }
}