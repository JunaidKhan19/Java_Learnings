package learnings.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
		Set<String> treeset;
		treeset = new TreeSet<String>();
		
		treeset.add("Mumbai");
		treeset.add("Pune");
		treeset.add("Kolkata");
		treeset.add("Chennai");
		treeset.add("Nagpur");
		System.out.println(treeset);//ordered by insertion
		treeset.add("Mumbai");
		System.out.println(treeset);
		treeset.contains("Mumbai"); // returns boolean value
		
		//hshset.get(0); cant be applied because no indexing
		
		for(String city : treeset) {
			System.out.println(city);
		}
		
		// Iterator
		//step 1 : make Iterator obj
		Iterator<String> i;
		i = treeset.iterator();
		
		//step 2 : write a loop 
		while(i.hasNext()) {
			String city = i.next(); //step 3 : get next element
			System.out.println(city);
			if(city.equals("Pune")) i.remove(); //step 4 : to remove
		}
		System.out.println(treeset);
		treeset.clear();
	}
}
