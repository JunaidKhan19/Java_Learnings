package multithreading_and_synchronization;

public class Chef extends Thread {
    private String name;
    private Dish sharedDish;

    public Chef(String name, Dish dish) {
        this.name = name;
        this.sharedDish = dish;
        setName(name);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(getName() + " is trying to prepare the dish...");
            sharedDish.prepareDish();
        }
    }
}