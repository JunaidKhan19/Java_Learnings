package learnings;

public class StringsInJava {
	public static void main(String[] args) {
		String city = new String("Mumbai");
		
		System.out.println(city);
		System.out.println(city.length());// gives actual length
		System.out.println(city.charAt(2));// gives character at that index
		System.out.println(city.equals("Mumbai"));//compares the strings returns boolean value
		System.out.println(city.equals("mumbai"));
		System.out.println(city.equalsIgnoreCase("mumbai"));//ignores cases and compares
		System.out.println(city.substring(2));//returns substring starting from index till last
		System.out.println(city.substring(2, 5));//first index parameter is inclusive and second is exclusive.
		
		//for replace it creates a new obj and old obj remains unchanged 
		city.replace('M', 'P');
		System.out.println(city);
		String newCity = city.replace('M', 'P'); //hence we store it in a new reference
		System.out.println(newCity);
		
		int a = 5;
		int b = 5;
		System.out.println("Equality on int references returns:"+ (a==b));
		
		String place1 = new String("Mumbai");
		System.out.println("Equality on String references returns:"+ (city==place1));
		System.out.println("but with .equals String references returns: "+ place1.equals(city));
		
		String c = "mumbai";
		String d = "mumbai";
		System.out.println("Equality on String constants references returns:"+ (c==d));
		
	}

}
