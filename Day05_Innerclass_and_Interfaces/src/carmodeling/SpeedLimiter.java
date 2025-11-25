package carmodeling;

public interface SpeedLimiter {
	int MAX_LIMIT = 160;
	int MIN_LIMIT = 0;
	
	void speedLimit(int speed);
}
