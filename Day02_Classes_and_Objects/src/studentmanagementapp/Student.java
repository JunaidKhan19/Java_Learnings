package studentmanagementapp;

public class Student {
	//instance variable
	//attributes of student 
	private int rollNumber;
	private String name;
	private float marks;
	
	//static variable
	private static int count;
	
	//instance method definition and this keyword
	void display() {
		System.out.println(this.rollNumber);
		System.out.println(this.name);
		System.out.println(this.marks);
	}
	
	void display(String format) {
		System.out.println("Roll.no \t Name \t Marks");
		for(int i = 0; i <= 40; i++) {
			System.out.print(format);
		}
		System.out.println();
		System.out.println(this.rollNumber + "      \t " + this.name + " \t " + this.marks);
		for(int i = 0; i <= 40; i++) {
			System.out.print(format);
		}
		System.out.println();
	}
	
	void accept(int rollNumber, String name, float marks) {
		this.rollNumber = rollNumber;
		this.marks = marks;
		this.name = name;
	}
	
	//non-args constructor
	/*Student(){
		System.out.println("Inside non-args constructor of student");
		this.rollNumber = 1;
		this.marks = 25.25f;
		this.name = "Guest";
	}*/
	
	//parameterized constructor
	Student(String name, float marks){
		System.out.println("Inside parameterized constructor of student");
		count++;
		this.rollNumber = count;
		this.marks = marks;
		this.name = name;
	}
	
	public static int getCount() {
		return count;
	}
	
	public static void displayMenu(String format) {
		System.out.println("Welcome to Student management system");
		for(int i = 0; i <= 40; i++) {
			System.out.print(format);
		}
		System.out.println();
		System.out.println("1. Register new Student");
		System.out.println("2. Display details");
		System.out.println("0. Exit");
		for(int i = 0; i <= 40; i++) {
			System.out.print(format);
		}
		System.out.println();
		System.out.println("Enter your choice:");
	}
}