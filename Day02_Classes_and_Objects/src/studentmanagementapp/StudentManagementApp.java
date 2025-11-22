package studentmanagementapp;
import java.util.Scanner;

public class StudentManagementApp {

	public static void main(String[] args) {
		//Create a reference of Student type.
		//Student s;
		
		//object creation and assigning to reference variable
		//System.out.println(s);//ERROR value not initialized
		//s = new Student();
		//System.out.println(s);//Prints something not readable
		
		//default value is assigned to local variable based on the data-type
		//System.out.println(s.rollNumber);
		//System.out.println(s.name);
		//System.out.println(s.marks);
		
		//to stop this we make sure roll-number is not accessible i.e private
		//s.rollNumber = -1;
		//s.name = "Junaid";
		//s.marks = 88.89f;
		
		//using this keyword
		//s.display();//invoking display() method
		
		//s.accept( 1, "Junaid", 99.99f);
		//s.display();
		
		//System.out.println("Number of students registered are:" + Student.getCount());
		//Student s1 = new Student("Aabhas", 99.99f);
		//s1.display("=");
		
		//System.out.println("Number of students registered are:" + Student.getCount());
		
		
		Scanner sc = new Scanner(System.in);
		String name;
		float marks;
		int choice;
		Student s1 = null;
		do {
			Student.displayMenu("=");
			choice = sc.nextInt(); //accepting user input
			switch(choice) {
			case 1:
				System.out.println("Enter name:");
				name = sc.next();
				System.out.println("Enter marks: ");
				marks = sc.nextFloat();
				s1 = new Student(name, marks);
				System.out.println("Student registered successfully.");
				break;
			case 2:
				if(s1 != null) s1.display("=");
				break;
			}
		} while(choice != 0);
		sc.close();
	}
}
