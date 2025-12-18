package studentmanagementapp.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import studentmanagementapp.entity.Student;
import studentmanagementapp.exception.StudentNotFoundException;

public class StudentDaoImpl {
	private List<Student> students;
	
	public StudentDaoImpl() {
		this.students = new ArrayList<Student>();
	}
	
	public void save(Student s) {
		this.students.add(s);
	}
	
	public List<Student> findAll(){
		return students;
	}
	
	public Student find(int rollNo) throws StudentNotFoundException{
		/* way 1 : imperative styled writing
		//searching student in array
		for(Student foundStudent: students) {
			if(foundStudent != null) {
				if(foundStudent.getRollNumber() == rollNo) {
					return foundStudent;
				}
			} 
		} 
		
		StudentNotFoundException e = new StudentNotFoundException("Student with rollNumber" + rollNo + " Notfound");
		throw e; //propogate exception 
		*/
		
		// way 2: 
		StudentNotFoundException e = new StudentNotFoundException("Student with rollNumber" + rollNo + " Notfound");
		return this.students.stream()
					.filter(s -> s.getRollNumber() == rollNo)
					.findFirst()
					.orElseThrow(() -> e);
		
	}
	
	public void deleteOne(int rollNo) throws StudentNotFoundException{
		Iterator<Student> i;
		i = students.iterator();
		
		//step 2 : write a loop 
		while(i.hasNext()) {
			Student student = i.next(); //step 3 : get next element
			if(student.getRollNumber() == rollNo) {
				i.remove(); //step 4 : to remove
				return;
			}
		}
		StudentNotFoundException e = new StudentNotFoundException("Student with rollNumber" + rollNo + " Notfound");
		throw e;
	}
}

