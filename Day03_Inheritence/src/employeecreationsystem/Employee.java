package employeecreationsystem;

public class Employee {
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
		System.out.println("Emp.no \t Name \t Marks");
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
	
	public double calculateSalary(){
		return getBasicSalary();
	}
	
	public static void displayMenu(String format) {
		System.out.println("Welcome to employee management system");
		for(int i = 0; i <= 40; i++) {
			System.out.print(format);
		}
		System.out.println();
		System.out.println("1. Register new Wage Employee");
		System.out.println("2. Register new Manager");
		System.out.println("3. Display details");
		System.out.println("0. Exit");
		for(int i = 0; i <= 40; i++) {
			System.out.print(format);
		}
		System.out.println();
		System.out.println("Enter your choice:");
	}
}
