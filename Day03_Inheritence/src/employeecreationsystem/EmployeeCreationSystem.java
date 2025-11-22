package employeecreationsystem;

import java.util.Scanner;

public class EmployeeCreationSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		double salary;
		int hours;
		int rate;
		int choice;
		int incentive;
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
				System.out.println("Enter hours: ");
				hours = sc.nextInt();
				System.out.println("Enter rate: ");
				rate = sc.nextInt();
				emp = new WageEmployee(name, salary, hours, rate);
				System.out.println("Employee registered successfully.");
				break;
			case 2:
				System.out.println("Enter name:");
				name = sc.next();
				System.out.println("Enter salary: ");
				salary = sc.nextDouble();
				System.out.println("Enter incentive: ");
				incentive = sc.nextInt();
				emp = new Manager(name, salary, incentive);
				System.out.println("Employee registered successfully.");
				break;
			case 3:
				if(emp != null) emp.showDetails("=");
				break;
			case 0:
				break;
			}
		} while(choice != 0);
	}

}
