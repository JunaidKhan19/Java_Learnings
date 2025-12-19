package demojdbc;

public class DataUpdation {

	public static void main(String[] args) {
		DaoInterface<Student, Integer> daoRef = new StudentDao();

		Student foundStudent = daoRef.getOne(104);
		if(foundStudent != null) {
			foundStudent.setName("Aabhas Tripathi");
			foundStudent.setCity("Jabalpur");
			daoRef.update(foundStudent);
		} else {
			System.out.println("No such students found");
		}
	}

}
