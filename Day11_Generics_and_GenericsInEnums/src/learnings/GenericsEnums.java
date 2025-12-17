package learnings;

enum Operations{
	ADD, SUBTRACT, MULTIPLY, DIVIDE;
	
	public <T extends Number> double apply(T a, T b) {
		switch (this) {
			case ADD: 
				return a.doubleValue() + b.doubleValue();
			case SUBTRACT: 
				return a.doubleValue() - b.doubleValue();
			case MULTIPLY: 
				return a.doubleValue() * b.doubleValue();
			case DIVIDE: 
				return a.doubleValue() / b.doubleValue();
			default:
				return 0;
		}
	};
}

public class GenericsEnums {
	public static void main(String[] args) {
		double test = Operations.ADD.apply(10, 20);
		System.out.println(test);
	}
}
