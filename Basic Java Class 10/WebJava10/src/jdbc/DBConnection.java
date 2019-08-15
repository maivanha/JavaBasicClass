package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static private String connectionString;
	static private Connection connection;
	
	static {
		connectionString = "jdbc:mysql://localhost:3306/javacb10"
				+ "?useUnicode=true&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			if(connection == null || connection.isClosed())
				connection = DriverManager.getConnection(connectionString, 
														"root", "123456");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		DBConnection.connection = connection;
	}
}
