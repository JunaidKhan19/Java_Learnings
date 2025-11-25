package carmodeling;

public class Car{
	private String model;
	private boolean isEngineOn ;
	private int speed;
	private Speaker speaker;
	public Speaker getSpeaker() {
		return speaker;
	}
	
	public Car(String model, String speakerName, int speed) {
		this.model = model;
		this.isEngineOn = false;
		this.speaker = new Speaker(speakerName);
		this.speed = speed;
		System.out.println("Car constructor called");
	}
	
	//approach 1 of making inner class
	class Engine {
		private String engineName;
		public Engine(String engineName) {
			this.engineName = engineName;
			System.out.println("Engine constructor called");
		}
		
		public void start() {
			if(!isEngineOn) {
				isEngineOn = true;
				System.out.println(model + "'s engine " + engineName + " is on");
			} else {
				System.out.println(model + "'s engine " + engineName + " is already on");
			}
		}
		
		public void stop() {
			if(isEngineOn) {
				isEngineOn = false;
				System.out.println(model + "'s engine " + engineName + " is off");
			} else {
				System.out.println(model + "'s engine " + engineName + " is already off");
			}
		}
	}
	
	//approach 2 of making inner class
	class Speaker {
		private String speakerName;
		
		public Speaker(String speakerName) {
			this.speakerName = speakerName;
			System.out.println("Speaker constructor called");
		}
		
		public void playSong() {
			System.out.println(speakerName + " is playing song in " + model);
		}
	}
	
	static class Seats{
		private int numberOfSeats;
		
		public Seats(int numberOfSeats) {
			this.numberOfSeats = numberOfSeats;
		}
		
		public void displaySeatsInfo() {
			System.out.println(numberOfSeats + " seater model");
		}
	}
	
	public void checkSpeedlimit(SpeedLimiter speedlimit) {
		speedlimit.speedLimit(speed);
	}
}
