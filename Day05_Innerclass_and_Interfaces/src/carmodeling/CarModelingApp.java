package carmodeling;

public class CarModelingApp {
	public static void main(String[] args) {
		Car tata = new Car("TATA SAFARI", "JBL", 150); //main class car
		Car.Engine enginetata = tata.new Engine("5500cc");//member class inside the car , this is approach 1
		
		enginetata.start();
		enginetata.stop();
		
		tata.getSpeaker().playSong();//member class inside the car , this is approach 2
		
		//anonymous inner class
		Car honda = new Car("HONDA CITY", "HORIZON", 180);
		honda.checkSpeedlimit(new SpeedLimiter() {
			@Override
			public void speedLimit(int speed) {
				if (speed > MAX_LIMIT) {
					System.out.println("the speed is greater than limit");
				} else if (speed < MIN_LIMIT) {
					System.out.println("the speed is less than limit");
				}
			}
		});
		
		//static inner class
		//Car.Seats sixSeater = new Car.Seats(6);
		//Car.Seats fourSeater = new Car.Seats(4);
		Car.Seats twoSeater = new Car.Seats(2);
		twoSeater.displaySeatsInfo();
	}
}

