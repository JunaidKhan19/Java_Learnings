package employeecreationsystem;

import java.util.Scanner;

public class EmployeeManagementSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		double salary;
		int choice;
		Employee emp = null;
		do {
			Employee.displayMenu("=");
			choice = sc.nextInt(); //accepting user input
			switch(choice) {
			case 1:
				System.out.println("Enter name:");
				name = sc.next();
				System.out.println("Enter salary: ");
				salary = sc.nextDouble();
				emp = new Employee(name, salary);
				System.out.println("Employee registered successfully.");
				break;
			case 2:
				if(emp != null) emp.showDetails("=");
				break;
			}
		} while(choice != 0);
	}

}
