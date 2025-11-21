package assignmentsday01;

public class PrintSkippingZeroes {

	public static void main(String[] args) {
		int number = 1007;
		int printNum = 0;
		int position = 1;
		while(number > 0) {
			int digit = number % 10;
			number = number/10;
			if(digit != 0) {
				printNum = printNum + (digit*position);
				position = position*10;
			}
		}
		System.out.println(printNum);
	}

}
