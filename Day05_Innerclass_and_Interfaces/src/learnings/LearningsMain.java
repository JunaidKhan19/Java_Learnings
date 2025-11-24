package learnings;

import static java.lang.System.out;
import static learnings.InnerClassExample.StaticInner;

public class LearningsMain {

	public static void main(String[] args) {
		//print using static imports from java.lang
		out.println("Printed using static import");
		
		//print using static imports from static inner class
		StaticInner.print();
		
		//Functional interfaces and lambda expression
//		Taxable t = (double income) -> {return income*0.2;}; is also valid
//		Taxable t = (income) -> {return income*0.2;};
//		Taxable t = income -> {return income*0.2;};
		Taxable t = income -> income*0.2;
		System.out.println(t.calculateTax(56070));
		
//		StringJoinable sj = (String s, String m) -> {return s+" "+m;}; 
//		StringJoinable sj = (s, m) -> {return s+" "+m;}; 
		StringJoinable sj = (s, m) -> s+" "+m;
		System.out.println(sj.join("Junaid", "Khan"));
		
//		Searchable s = (String name) -> {return true;};
//		Searchable s = (name) -> {return true;};
//		Searchable s = name -> {return true;};
//		Searchable s = name -> true;
		
//		LengthReturner lr = (String sr) -> {return sr.length();};
//		LengthReturner lr = (sr) -> {return sr.length();
//		LengthReturner lr = sr -> {return sr.length();};
		LengthReturner lr = sr -> sr.length();;
		
		System.out.println(lr.calculateLength("Junaid"));



		
	}

}
