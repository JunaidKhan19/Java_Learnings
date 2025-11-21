package employeecreationsystem;

public class Employee {
	private int id;
	private String name;
	private double basicSalary;
	private static int count;
	
	public Employee(String name, double basicSalary) {
		count++;
		this.id = count;
		this.name = name;
		this.basicSalary = basicSalary;
	}
	
	public void showDetails(String format) {
		System.out.println("Emp.no \t Name \t Marks");
		for(int i = 0; i <= 40; i++) {
			System.out.print(format);
		}
		System.out.println();
		System.out.println(this.id + "  \t " + this.name + " \t " + this.basicSalary);
		for(int i = 0; i <= 40; i++) {
			System.out.print(format);
		}
		System.out.println();
	}
	
	public double calculateSalary(){
		return basicSalary;
	}
	
	public static void displayMenu(String format) {
		System.out.println("Welcome to employee management system");
		for(int i = 0; i <= 40; i++) {
			System.out.print(format);
		}
		System.out.println();
		System.out.println("1. Register new Employee");
		System.out.println("2. Display details");
		System.out.println("0. Exit");
		for(int i = 0; i <= 40; i++) {
			System.out.print(format);
		}
		System.out.println();
		System.out.println("Enter your choice:");
	}

}
