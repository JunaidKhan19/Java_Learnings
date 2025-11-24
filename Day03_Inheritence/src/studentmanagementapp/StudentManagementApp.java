package studentmanagementapp;

import java.util.Scanner;

public class StudentManagementApp {

	public static void main(String[] args) {
		//Create a reference of Student type.	
		
		Scanner sc = new Scanner(System.in);
		String name;
		float marks;
		int choice;
		Student s1 = null;
		do {
			Student.displayMenu("=");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter name:");
				name = sc.next();
				System.out.println("Enter marks: ");
				marks = sc.nextFloat();
				s1 = new Student(name, marks);
				System.out.println("Employee registered successfully.");
				break;
			case 2:
				if(s1 != null) s1.display("=");
				break;
			}
		} while(choice != 0);
		sc.close();
		
	}

}
