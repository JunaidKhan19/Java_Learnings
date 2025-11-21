package learnings;

public class VariablesAndDatatypes {

	public static void main(String[] args) {
		//whole number values example: rollno, 
		//byte
		//short
		int num = 10;
		//long
		System.out.println(num);

		//decimal values example: marks, percentage
		float marks = 88.98f;
		//double
		System.out.println(num);

		//single character in single quotes
		char dollarSymbol = '$';
		System.out.println(dollarSymbol);

		// true or false values
		boolean isActive = true;
		System.out.println(isActive);


		//type-casting
		int smallContainer = 10;
		long bigContainer = 1534;
		smallContainer = (int)bigContainer; //narrowing -: explicitly done or we have to do it.
		bigContainer = smallContainer; //widening -: implicitly done or automatically done
	}

}
