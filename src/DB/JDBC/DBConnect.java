package DB.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private static Connection connection;
	public static Connection getConnction() {
			try {
				if(connection==null) {
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/universal","root","Rishi@9838");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
		return connection;
	}

}
