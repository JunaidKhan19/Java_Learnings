package employeecreationsytem.entity;

public abstract class Employee {
	private int id;
	private String name;
	private double basicSalary;
	private static int count;
	
	public Employee(String name, double basicSalary) {
		count++;
		this.id = count;
		this.setName(name);
		this.setBasicSalary(basicSalary);
	}
	
	public void showDetails(String format) {
		System.out.println("Emp.no \t Name \t Salary");
		for(int i = 0; i <= 40; i++) {
			System.out.print(format);
		}
		System.out.println();
		System.out.println(this.getId() + "  \t " + this.getName() + " \t " + this.getBasicSalary());
		for(int i = 0; i <= 40; i++) {
			System.out.print(format);
		}
		System.out.println();
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	
	public abstract double calculateSalary();
	
	public static void displayMenu(String format) {
		System.out.println("Welcome to employee management system");
		for(int i = 0; i <= 40; i++) {
			System.out.print(format);
		}
		System.out.println();
		System.out.println("1. Register new Wage Employee");
		System.out.println("2. Register new Manager");
		System.out.println("3. Display details of wage employees");
		System.out.println("4. Display details of Managers");
		System.out.println("5. Search employees by Id");
		System.out.println("6. Delete employees by id");
		System.out.println("0. Exit");
		for(int i = 0; i <= 40; i++) {
			System.out.print(format);
		}
		System.out.println();
		System.out.println("Enter your choice:");
	}
}
