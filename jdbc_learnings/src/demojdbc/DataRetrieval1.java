package demojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataRetrieval1 {

	public static void main(String[] args) {
		// Program to retrieve data from database using SELECT query and display it.
		//1. Load the driver
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driverClassName);
			System.out.println("Driver Loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//2. Establish Connection
		String connectionUrl = "jdbc:mysql://localhost:3306/cdac?useSSL=false";
		String userId = "root";
		String password = "Junaidroot@123";
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			dbConnection = DriverManager.getConnection(connectionUrl, userId, password);
			System.out.println("Connected to db");
			
			//3. Get some statement
			statement = dbConnection.createStatement();
			
			//4. Execute a query
			String sqlQuery = "select student_name, student_city, student_id from students";
			
			//5. For SELECT query, obtain ResultSet and perform navigation.
			rs = statement.executeQuery(sqlQuery);	
			
			while(rs.next()) {
				String name = rs.getString(1);//name 
				String city = rs.getString(2);//City
				int id = rs.getInt(3);
				System.out.println(id+","+name+","+city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//Note close in reverse order
				rs.close();
				statement.close();
				dbConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
