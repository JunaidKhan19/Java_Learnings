package learnings;

public class MultipleCatchBlocks {
	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 0;
		try {
			String s = null;
			System.out.println(s.length());
			System.out.println(args[0]);
			int result = num1/num2;
			System.out.println("Result is " + result);
		} catch(ArithmeticException e) {
			System.out.println("Cannot divide by zero");
			e.printStackTrace();// this prints complete stack trace on console helpful to debug
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("array index out of range");
			e.printStackTrace();
		} catch(NullPointerException e) {
			System.out.println("cannot invoke methods on null.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("Generic");
			e.printStackTrace();
		}
		System.out.println("After");
	}
}
