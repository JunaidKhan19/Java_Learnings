package demojdbc;

public class DataInsertion {

	public static void main(String[] args) {
		DaoInterface<Student, Integer> daoRef = new StudentDao();

		Student student = new Student(104, "Sunil", "Chennai");
		daoRef.create(student);
	}

}
