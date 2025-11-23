package wrapperclass;

public class WrapperClass {

	public static void main(String[] args) {
		//primitive
		int i = 10;
		
		//primitive to wrapper
		Integer iObj = i; //auto-boxing
		
		//wrapper to primitive 
		int j = iObj.intValue(); //auto-unboxing
		
		
		
		//String to Wrapper
		Integer o = Integer.valueOf("77");
		
		//Wrapper to String
		String str = o.toString();
		
		
		
		//String to Primitive
		int p = Integer.parseInt("78");
		
		//primitive to String
		String data = Integer.toString(p);
	}

}
