package studentmanagementapp.app;

import java.util.Scanner;

import studentmanagementapp.entity.Student;
import studentmanagementapp.exception.StudentNotFoundException;

public class StudentManagementApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int indexCount = 0;
		String name;
		float marks;
		int choice;	
		Student[] students= new Student[2];
		
		do {
			Student.displayMenu("=");
			choice = sc.nextInt(); //accepting user input
			switch(choice) {
			case 1:
				System.out.println("Enter name:");
				name = sc.next();
				System.out.println("Enter marks: ");
				marks = sc.nextFloat();
				if(indexCount <= students.length) {
					for(int i = 0; i<students.length; i++ ) {
						if(students[i] != null) {
							continue;
						} else {
							students[i] = new Student(name, marks, null);
							System.out.println("Student registered successfully.");
						}
					}
				} else {
					System.err.println("Limit Exceeded");
				}
				break;
			case 2:
				System.out.println("Roll.no \t Name \t Marks");
				for(int i = 0; i <= 40; i++) {
					System.out.print("=");
				}
				for(int i = 0; i<=students.length; i++) {
					if(students != null) students[i].display("=");
				}
				break;
			case 3:
				System.out.println("Enter the Roll.No: ");
				int r = sc.nextInt();
				boolean isFound = false;
				try {
					//searching student in array
					for(Student foundStudent: students) {
						if(foundStudent != null) {
							//if student roll.no == accepted roll no
							if(foundStudent.getRollNumber() == r) {
								System.out.println(foundStudent);
								isFound = true;
								break;
							}
						} 
					} 
					if (!isFound) {
						try {
							throw new StudentNotFoundException("student with roll no: "+ r + " not found!!!");
						} catch(StudentNotFoundException ex) {
							System.out.println("Error searching student with roll no: "+ r);
							ex.printStackTrace();
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					System.out.println("search terminated..");
				}
				break;
			case 0:
				break;
			}
		} while(choice != 0);

	}

}

