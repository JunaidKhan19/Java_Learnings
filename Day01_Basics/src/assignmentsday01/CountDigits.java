package assignmentsday01;

public class CountDigits {
	public static void main(String[] args) {
		int number = 678;
		int count = 0;
		while(number > 0) {
			number = number/10;
			count++;
		}
		System.out.println(count);
	}
}
