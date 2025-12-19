package demojdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class StudentDao implements DaoInterface<Student, Integer> {

	@Override
	public Collection<Student> getAll() {
		/* this method retrieves all the records from students table
		 * converts them into Java objects of student class and
		 * returns all the objects in the form of collection.
		*/
		
		Collection<Student> allStudents = new ArrayList<Student>();
		String sqlQuery = "select student_name, student_city, student_id from students";
		try (
			Connection dbConnection = JdbcUtils.getConnection();
			Statement stmt = dbConnection.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery);
		){
			while(rs.next()) {
				String name = rs.getString(1);//name 
				String city = rs.getString(2);//City
				int id = rs.getInt(3);
				
				Student stdObj = new Student(id, name, city);
				allStudents.add(stdObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allStudents;
	}

	@Override
	public Student getOne(Integer studentId) {
		/*This method accepts student id as Integer and returns student object with that id.
		 * if id is non existing it returns null.
		*/
		
		Student foundStudent = null;
		String sqlQuery = "select student_name, student_city, student_id from students where student_id = ?";
		try (
			Connection dbConnection = JdbcUtils.getConnection();	
			PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
		){
			//setting value for ? in query
			pstmt.setInt(1, studentId);
			ResultSet rs = pstmt.executeQuery();
			
			//after execution
			if(rs.next()) {
				String name = rs.getString(1);//name 
				String city = rs.getString(2);//City
				int id = rs.getInt(3);
				foundStudent = new Student(id, name, city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return foundStudent;
	}

	@Override
	public void create(Student studentObj) {
		/*This method accept a student object and stores it as a record to students table*/
		
		String sqlQuery = "insert into students values (?, ?, ?)";
		try (
				Connection dbConnection = JdbcUtils.getConnection();	
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
			){
			//Fetching the values from studentObj
			int id = studentObj.getId();//id
			String name = studentObj.getName();//name 
			String city = studentObj.getCity();//

			//setting value for ? in query
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, city);
			
			//we dont require ResultSet hence executeUpdate is used.
			int count = pstmt.executeUpdate();
			System.out.println(count + " Records inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Student studentObj) {
		/*This method receives modified state of the student object 
		 * and reflect it back to db to complete the update operation
		*/
		
		String sqlQuery = "update students set student_name = ?, student_city = ? where student_id = ?";
		try (
				Connection dbConnection = JdbcUtils.getConnection();	
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
			){
			//Fetching the values from studentObj
			int id = studentObj.getId();//id
			String name = studentObj.getName();//name 
			String city = studentObj.getCity();//

			//setting value for ? in query
			pstmt.setInt(3, id);
			pstmt.setString(1, name);
			pstmt.setString(2, city);
			
			//we dont require ResultSet hence executeUpdate is used.
			int count = pstmt.executeUpdate();
			System.out.println(count + " Records updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOne(Integer studentId) {
		/*This method accepts id of the student object and delete it.
		*/
		
		String sqlQuery = "delete from students where student_id = ?";
		try (
				Connection dbConnection = JdbcUtils.getConnection();	
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
			){
			//setting value for ? in query
			pstmt.setInt(1, studentId);
			
			//we dont require ResultSet hence executeUpdate is used.
			int count = pstmt.executeUpdate();
			System.out.println(count + " Records deleted");
		} catch (SQLException e) {
			e.printStackTrace();
			}
	}

}
