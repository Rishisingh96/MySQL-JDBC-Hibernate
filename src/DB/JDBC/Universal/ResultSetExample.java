package DB.JDBC.Universal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/universal";
        String user = "root";
        String password = "Rishi@9838";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT Roll_No, name FROM student")) {

            while (rs.next()) {
                int rollNo = rs.getInt("Roll_No");
                String name = rs.getString("Name");
                System.out.println("Roll_No: " + rollNo + ", Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
