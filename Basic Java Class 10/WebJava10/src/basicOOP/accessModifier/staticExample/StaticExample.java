package basicOOP.accessModifier.staticExample;

import java.sql.Connection;

public class StaticExample {
	public static String CONNECTION_STRING = "CHUOI KET NOI";
	private static Connection con;
	
	static {
		CONNECTION_STRING = "Khoi tao gia tri cho connection string"; 
	}
	
	public static Connection getConnection() {
		System.out.println("Thu thi hamg getConnection");
		System.out.println(CONNECTION_STRING);
		Connection co1 = con;
		return null;
	}
}
