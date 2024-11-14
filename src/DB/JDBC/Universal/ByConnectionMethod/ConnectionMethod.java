package DB.JDBC.Universal.ByConnectionMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMethod {
    public static Connection ConnectionDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/universal";
        String user = "root";
        String pass = "Rishi@9838";
        Connection con = DriverManager.getConnection(url, user, pass);
        return con;  // Return the Connection object
    }

    public static void main(String[] args) throws SQLException {
        Connection con = ConnectionDB();
        if (con != null) {
            System.out.println("Connection Established");
        } else {
            System.out.println("Failed to establish connection");
        }
    }
}
