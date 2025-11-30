package learnings.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		Set<String> hshset;
		hshset = new HashSet<String>();
		
		hshset.add("Mumbai");
		hshset.add("Pune");
		hshset.add("Kolkata");
		hshset.add("Chennai");
		hshset.add("Nagpur");
		System.out.println(hshset);
		hshset.add("Mumbai");
		System.out.println(hshset);
		hshset.contains("Mumbai"); // returns boolean value
		
		//hshset.get(0); cant be applied because no indexing
		
		hshset.clear();
	}
}
