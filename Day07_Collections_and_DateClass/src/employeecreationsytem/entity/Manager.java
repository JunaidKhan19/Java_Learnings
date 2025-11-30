package employeecreationsytem.entity;

public class Manager extends Employee{
	private int incentives;

	public Manager(String name, double basicSalary, int incentives) {
		super(name, basicSalary);
		this.incentives = incentives;
	}

	public int getIncentives() {
		return incentives;
	}

	public void setIncentives(int incentives) {
		this.incentives = incentives;
	}
	
	@Override
	public double calculateSalary() {
		return getBasicSalary() + incentives;
	}
	
	@Override
	public void showDetails(String format) {
		System.out.println("Emp.no \t Name \t Basic Salary \t Incentive \t final Salary");
		for(int i = 0; i <= 60; i++) {
			System.out.print(format);
		}
		System.out.println();
		System.out.println(this.getId() + "  \t " + this.getName() + " \t " + this.getBasicSalary() + " \t " + getIncentives() + " \t \t" + calculateSalary());
		for(int i = 0; i <= 60; i++) {
			System.out.print(format);
		}
		System.out.println();
	}
}
