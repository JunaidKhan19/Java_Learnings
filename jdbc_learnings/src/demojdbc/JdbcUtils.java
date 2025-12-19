package demojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
	public static Connection getConnection() throws SQLException {
		//this method is used to establish connection with db and return it.
		//2. Establish Connection
		String connectionUrl = "jdbc:mysql://localhost:3306/cdac?useSSL=false";
		String userId = "root";
		String password = "Junaidroot@123";
		Connection dbConnection = DriverManager.getConnection(connectionUrl, userId, password);
		
		return dbConnection;
	}
}
