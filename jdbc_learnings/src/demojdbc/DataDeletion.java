package demojdbc;

public class DataDeletion {

	public static void main(String[] args) {
		DaoInterface<Student, Integer> daoRef = new StudentDao();
		
		int id  = 104;
		daoRef.deleteOne(id);		
	}

}
