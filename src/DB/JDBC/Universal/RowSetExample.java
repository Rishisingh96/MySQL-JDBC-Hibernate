package DB.JDBC.Universal;

import com.sun.rowset.CachedRowSetImpl;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;

public class RowSetExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/universal";
        String user = "root";
        String password = "Rishi@9838";

        try (CachedRowSet rowSet = new CachedRowSetImpl()) {
            rowSet.setUrl(url);
            rowSet.setUsername(user);
            rowSet.setPassword(password);
            rowSet.setCommand("SELECT Roll_No, name FROM student");
            rowSet.execute();

            while (rowSet.next()) {
                int rollNo = rowSet.getInt("Roll_No");
                String name = rowSet.getString("Name");
                System.out.println("Roll_No: " + rollNo + ", Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
