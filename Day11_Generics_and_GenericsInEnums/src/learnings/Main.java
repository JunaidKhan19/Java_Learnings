package learnings;

public class Main {

	public static void main(String[] args) {
		
		//GENERICS
		/*
		// ---- without generics ---- //
		Box box = new Box();
		box.setValue(1);
		//int i = box.getValue(); //this will give error since box.value is Object type not an int type
		int i = (Integer) box.getValue(); //type casted
		System.out.println(i);
		//String s = (String) box.getValue();//this will give error since the value 1 is an integer 
		//System.out.println(s);
		*/
		
		// ---- with generics ---- //
		Box <Integer> box = new Box<>();//this is now typesafe
		box.setValue(1);
		int i = box.getValue();
		System.out.println(i);
		
		Box <String> sbox = new Box<>();
		sbox.setValue("Junaid");
		String name = sbox.getValue();
		System.out.println(name);
		
	}

}
