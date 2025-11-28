package learnings;

import java.util.Scanner;

public class StudentNotFoundException extends RuntimeException{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter roll number: ");
		int r = sc.nextInt();
		
		if(r != 1) {
			//making a custom exception
			StudentNotFoundException e = new StudentNotFoundException();
			throw e;
		}
	}

}
