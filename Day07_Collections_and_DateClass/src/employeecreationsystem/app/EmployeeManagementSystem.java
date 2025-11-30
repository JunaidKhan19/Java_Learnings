package employeecreationsystem.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import employeecreationsytem.entity.Employee;
import employeecreationsytem.entity.EmployeeNotFoundException;
import employeecreationsytem.entity.Manager;
import employeecreationsytem.entity.WageEmployee;

public class EmployeeManagementSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		double salary;
		int hours;
		int rate;
		int choice;
		int incentive;
		List<WageEmployee> wageEmployees = new ArrayList<WageEmployee>();
		List<Manager> managerList = new ArrayList<Manager>();
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
				WageEmployee e = new WageEmployee(name, salary, hours, rate);
				wageEmployees.add(e);
				System.out.println("Employee registered successfully.");
				break;
			case 2:
				System.out.println("Enter name:");
				name = sc.next();
				System.out.println("Enter salary: ");
				salary = sc.nextDouble();
				System.out.println("Enter incentive: ");
				incentive = sc.nextInt();
				Manager m = new Manager(name, salary, incentive);
				managerList.add(m);
				System.out.println("Employee registered successfully.");
				break;
			case 3:
				for(WageEmployee emp : wageEmployees) {
					emp.showDetails("=");
					}
				break;
			case 4:
				for(Manager emp : managerList) {
					emp.showDetails("=");
					}
				break;
			case 5:
				System.out.println("Enter type of employee:");
				System.out.println("1. Wage Employee \t 2. Manager");
				int typeOfEmployee = sc.nextInt();
				System.out.println("Enter id of employee:");
				int id = sc.nextInt();
				boolean isFound = false;
				if(typeOfEmployee == 1) {
					for(WageEmployee wgemp: wageEmployees) {
						if(wgemp != null) {
							if(wgemp.getId() == id) {
								System.out.println("Roll.no \t Name \t Marks");
								for(int i = 0; i <= 40; i++) {
									System.out.print("=");
								}
								wgemp.showDetails("=");
								isFound = true;
								break;
							}
						} 
					} 
					if (!isFound) {
						try {
							throw new EmployeeNotFoundException("student with roll no: "+ id + " not found!!!");
						} catch(EmployeeNotFoundException ex) {
							System.out.println("Error searching student with roll no: "+ id);
							ex.printStackTrace();
						}
					}
				} else if(typeOfEmployee == 2) {
					for(Manager mgemp: managerList) {
						if(mgemp != null) {
							if(mgemp.getId() == id) {
								System.out.println("Roll.no \t Name \t Marks");
								for(int i = 0; i <= 40; i++) {
									System.out.print("=");
								}
								mgemp.showDetails("=");
								isFound = true;
								break;
							}
						} 
					} 
					if (!isFound) {
						try {
							throw new EmployeeNotFoundException("student with roll no: "+ id + " not found!!!");
						} catch(EmployeeNotFoundException ex) {
							System.out.println("Error searching student with roll no: "+ id);
							ex.printStackTrace();
						}
					}
				}
			case 6:
				//Delete Employees
				break;
			case 0:
				break;
			}
		} while(choice != 0);
	}

}
