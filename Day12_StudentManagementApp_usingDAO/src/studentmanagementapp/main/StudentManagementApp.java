package studentmanagementapp.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import studentmanagementapp.dao.StudentDaoImpl;
import studentmanagementapp.entity.Student;
import studentmanagementapp.exception.StudentNotFoundException;

public class StudentManagementApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String name;
		float marks;
		int choice;	
		//Student[] students= new Student[2]; //transition from array to collections
		//List<Student> students = new ArrayList<Student>(); //transition from List to Dao class object
		StudentDaoImpl dao = new StudentDaoImpl();
		do {
			Student.displayMenu("=");
			choice = sc.nextInt(); //accepting user input
			switch(choice) {
			case 1:
				System.out.println("Enter name:");
				name = sc.next();
				System.out.println("Enter marks: ");
				marks = sc.nextFloat();
				List<String> subjects = new ArrayList<String>();
				System.out.println("Enter how many subjects: ");
				int subjs = sc.nextInt();
				int n = 0;
				while(n < subjs) {
					System.out.println("Enter " + n + " subject :");
					String subject = sc.next();
					subjects.add(subject);
					n++;
				}
				Student s = new Student(name, marks, null, subjects);
				//students.add(s);
				dao.save(s);
				break;
			case 2:
				System.out.println("Roll.no \t Name \t Marks");
				for(int i = 0; i <= 40; i++) {
					System.out.print("=");
				}
				/*for(Student student: students) {
					student.display("=");
				}*/
				for(Student student: dao.findAll()) {
					student.display("=");
				}
				break;
			case 3:
				System.out.println("Enter the Roll.No: ");
				int r = sc.nextInt();
				try {
					Student searchedStudent = dao.find(r);
					System.out.println("Roll.no \t Name \t Marks");
					for(int i = 0; i <= 40; i++) {
						System.out.print("=");
					}
					searchedStudent.display("=");
				} catch (StudentNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Enter the Roll.No: ");
				r = sc.nextInt();
				try {
					dao.deleteOne(r);
				} catch (StudentNotFoundException e) {
					e.printStackTrace();
				}
				dao.findAll();
				break;
			case 5:
				Collections.sort(dao.findAll());
				System.out.println("Roll.no \t Name \t Marks");
				for(int j = 0; j <= 40; j++) {
					System.out.print("=");
				}
				for(Student stud: dao.findAll()) {
					stud.display("=");
				}
				break;
			case 6:
				Collections.sort(dao.findAll(), 
						(s1,s2) -> s1.getName().compareTo(s2.getName())
				);
				System.out.println("Roll.no \t Name \t Marks");
				for(int j = 0; j <= 40; j++) {
					System.out.print("=");
				}
				for(Student stud: dao.findAll()) {
					stud.display("=");
				}
				break;
			case 0:
				break;
			}
		} while(choice != 0);
		sc.close();
	}

}
