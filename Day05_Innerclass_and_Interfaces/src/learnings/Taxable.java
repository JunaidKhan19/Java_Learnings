package learnings;

@FunctionalInterface
public interface Taxable {
	double calculateTax(double income);
}
