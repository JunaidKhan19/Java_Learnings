package studentmanagementapp.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import studentmanagementapp.entity.Student;
import studentmanagementapp.exception.StudentNotFoundException;

public class StudentManagementApp {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String name;
		float marks;
		int choice;	
		//Student[] students= new Student[2]; //transition from array to collections
		List<Student> students = new ArrayList<Student>();
		do {
			Student.displayMenu("=");
			choice = sc.nextInt(); //accepting user input
			switch(choice) {
			case 1:
				System.out.println("Enter name:");
				name = sc.next();
				System.out.println("Enter marks: ");
				marks = sc.nextFloat();
				Student s = new Student(name, marks, null);
				students.add(s);
				sc.close();
				break;
			case 2:
				System.out.println("Roll.no \t Name \t Marks");
				for(int i = 0; i <= 40; i++) {
					System.out.print("=");
				}
				for(Student student: students) {
					student.display("=");
				}
				break;
			case 3:
				System.out.println("Enter the Roll.No: ");
				int r = sc.nextInt();
				boolean isFound = false;
				//searching student in array
				for(Student foundStudent: students) {
					if(foundStudent != null) {
						//if student roll.no == accepted roll no
						if(foundStudent.getRollNumber() == r) {
							System.out.println("Roll.no \t Name \t Marks");
							for(int i = 0; i <= 40; i++) {
								System.out.print("=");
							}
							foundStudent.display("=");
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
				sc.close();
				break;
			case 4:
				System.out.println("Enter the Roll.No: ");
				r = sc.nextInt();
				boolean isPresent = false;

				Iterator<Student> i;
				i = students.iterator();
				
				//step 2 : write a loop 
				while(i.hasNext()) {
					Student student = i.next(); //step 3 : get next element
					// System.out.println(student);
					if(student.getRollNumber() == r) {
						isPresent = true;
						i.remove(); //step 4 : to remove
					}
				}
				if (!isPresent) {
					try {
						throw new StudentNotFoundException("student with roll no: "+ r + " not found!!!");
					} catch(StudentNotFoundException ex) {
						System.out.println("Error searching student with roll no: "+ r);
						ex.printStackTrace();
					}
				}
				sc.next();
				break;
			case 5:
				Collections.sort(students);
				System.out.println("Roll.no \t Name \t Marks");
				for(int j = 0; j <= 40; j++) {
					System.out.print("=");
				}
				for(Student stud: students) {
					stud.display("=");
				}
				break;
			case 6:
				Collections.sort(students, 
						(s1,s2) -> s1.getName().compareTo(s2.getName())
				);
				System.out.println("Roll.no \t Name \t Marks");
				for(int j = 0; j <= 40; j++) {
					System.out.print("=");
				}
				for(Student stud: students) {
					stud.display("=");
				}
				break;
			case 0:
				break;
			}
		} while(choice != 0);

	}

}
