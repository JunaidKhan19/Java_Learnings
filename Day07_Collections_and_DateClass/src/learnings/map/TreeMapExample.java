package learnings.map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
	public static void main(String[] args) {
		Map<Integer, String> cities;
		cities = new TreeMap<Integer, String>();
		
		cities.put(121,"Mumbai");
		cities.put(111,"Delhi");
		cities.put(141,"Kolkata");
		cities.put(131,"Banglore");
		System.out.println(cities);
		System.out.println(cities.size());
		System.out.println(cities.containsKey(121));
		System.out.println(cities.containsValue("Banglore"));		
		
		cities.put(111, "Mumbai");
		//duplicate value is allowed but duplicate keys aren't. 
		//this will override 111

		cities.remove(121);//pass key to remove that key-value pair.
		cities.clear();//clear all elements	
	}
}
