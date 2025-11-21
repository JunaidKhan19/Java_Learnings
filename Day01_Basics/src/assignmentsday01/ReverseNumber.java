package assignmentsday01;

public class ReverseNumber {
	public static void main(String[] args) {
		int number = 678;
		int reverseNum = 0;
		while(number > 0) {
			int digit = number%10;
			number = number/10;
			reverseNum = (reverseNum*10) + digit;
		}
		System.out.println(reverseNum);
	}
}
