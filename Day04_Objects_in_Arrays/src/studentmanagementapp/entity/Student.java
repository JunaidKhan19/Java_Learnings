package studentmanagementapp.entity;

public class Student {
	private int rollNumber;
	private String name;
	private float marks;
	private static int count;
	
	//has a relationship - composition
	private Address postalAddress;
	
	//has a relationship - aggregation
	private Trainer instructor;
	
	public Student(String name, float marks, Address postalAddress){
		System.out.println("Inside parameterized constructor of student");
		count++;
		this.rollNumber = count;
		this.marks = marks;
		this.name = name;
		this.postalAddress = getPostalAddress();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMarks(float marks) {
		this.marks = marks;
	}
	
	public String getName() {
		return this.name;
	}
	
	public float getMarks() {
		return this.marks;
	}
	
	public int getRollNumber() {
		return this.rollNumber;
	}
	
	public static int getCount() {
		return count;
	}
	
	public Address getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(Address postalAddress) {
		this.postalAddress = postalAddress;
	}

	public Trainer getInstructor() {
		return instructor;
	}

	public void setInstructor(Trainer instructor) {
		this.instructor = instructor;
	}

	public void display(String format) {
		System.out.println();
		System.out.println(this.rollNumber + "      \t " + this.name + " \t " + this.marks);
		for(int i = 0; i <= 40; i++) {
			System.out.print(format);
		}
		System.out.println();
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