package employeecreationsytem.entity;

public class WageEmployee extends Employee{
	private int hours;
	private int rate;
	
	public WageEmployee(String name, double basicSalary, int hours, int rate) {
		super(name, basicSalary);
		this.hours = hours;
		this.rate = rate;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	
	@Override
	public double calculateSalary() {
		return getBasicSalary() + hours*rate;
	}
	
	@Override
	public void showDetails(String format) {
		System.out.println("Emp.no \t Name \t Basic Salary \t HourlyRate \t final Salary");
		for(int i = 0; i <= 40; i++) {
			System.out.print(format);
		}
		System.out.println();
		System.out.println(this.getId() + "  \t " + this.getName() + " \t " + this.getBasicSalary() + " \t " + getRate() + " \t \t" + calculateSalary());
		for(int i = 0; i <= 40; i++) {
			System.out.print(format);
		}
		System.out.println();
	}
	
}
