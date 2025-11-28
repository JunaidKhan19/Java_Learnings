package learnings;

public class FinallyBlock {
	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 0;
		try {
			int result = num1/num2;
			System.out.println("Result is " + result);
		} catch(ArithmeticException e) {
			System.out.println("Cannot divide by zero");
			e.printStackTrace();// this prints complete stack trace on console helpful to debug
		} finally {
			System.out.println("In finally");
		}
	}
}
