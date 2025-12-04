package studentmanagementapp.entity;

import java.util.HashSet;
import java.util.Set;

public class DemoHashCodeEquals {
	public static void main(String[] args) {
		// HashCode and Equals are used by collections having hash in their names
		// HashCode generates hash while Equals checks if the elements aren't equal on the memory location. 
		
		Set<Student> studentSet = new HashSet<Student>();
		
		Student s1 = new Student("Ajay", 88, null);
		Student s2 = new Student("Ajay", 88, null);
		
		studentSet.add(s1);
		studentSet.add(s2);
		
		System.out.println(studentSet.size());
	}

}
