package demojdbc;

import java.util.Collection;

public class DataRetrieval2 {

	public static void main(String[] args) {
		DaoInterface<Student, Integer> daoRef = new StudentDao();
		
		Collection<Student> allStudents = daoRef.getAll();
//		for(Student st: allStudents) {
//			System.out.println(st);
//		}
		
		//using lambda 
		allStudents.stream().forEach(student -> System.out.println(student));
		
		System.out.println("**********************************************************");
		
		Student student = daoRef.getOne(104);
		if(student == null) {
			System.out.println("Student with given id does not exist");
		} else
			System.out.println(student);
	}

}
