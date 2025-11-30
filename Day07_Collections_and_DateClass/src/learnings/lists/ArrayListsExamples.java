package learnings.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListsExamples {
	public static void main(String[] args) {
		List cities = new ArrayList();
		System.out.println(cities.size()); //gives the size of that Arraylist
		
		cities.add("Mumbai");// add element
		cities.add("Pune");
		System.out.println(cities);
		
		cities.add(1, "Kolkata"); //adds index based insertion
		System.out.println(cities);
		System.out.println(cities.size());
		System.out.println(cities.get(1)); //index based fetch
		
		cities.remove(1); //index based remove
		//cities.clear();// removes all elements
		
		cities.add("Mumbai");// Array list can have duplicates
		
		cities.add(12);// arraylist can hold different data by boxing them
		
		Collections.sort(cities);
		//Collections class has static method to sort
	}

}
