package learnings.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExamples {
	public static void main(String[] args) {
		Set<String> lkdhshset;
		lkdhshset = new LinkedHashSet<String>();
		
		lkdhshset.add("Mumbai");
		lkdhshset.add("Pune");
		lkdhshset.add("Kolkata");
		lkdhshset.add("Chennai");
		lkdhshset.add("Nagpur");
		System.out.println(lkdhshset);//ordered by insertion
		lkdhshset.add("Mumbai");
		System.out.println(lkdhshset);
		lkdhshset.contains("Mumbai"); // returns boolean value
		
		//hshset.get(0); cant be applied because no indexing
		
		lkdhshset.clear();
	}
}
