package DB.JDBC.Universal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableResultSetExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/universal";
        String user = "root";
        String password = "Rishi@9838";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement(
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery("SELECT Code, Name, Salary, Commission FROM employee")) {

            // Move to the first row and print the data
            if (rs.first()) {
                System.out.println("First Row - Code: " + rs.getInt("Code") + ", Name: " + rs.getString("Name") +
                        ", Salary: " + rs.getDouble("Salary") + ", Commission: " + rs.getDouble("Commission"));
            }

            // Move to the last row and print the data
            if (rs.last()) {
                System.out.println("Last Row - Code: " + rs.getInt("Code") + ", Name: " + rs.getString("Name") +
                        ", Salary: " + rs.getDouble("Salary") + ", Commission: " + rs.getDouble("Commission"));
            }

            // Move to the previous row from the current position and print the data
            if (rs.previous()) {
                System.out.println("Previous Row - Code: " + rs.getInt("Code") + ", Name: " + rs.getString("Name") +
                        ", Salary: " + rs.getDouble("Salary") + ", Commission: " + rs.getDouble("Commission"));
            }

            // Move to the 2nd row from the current position and print the data
            if (rs.relative(-2)) {
                System.out.println("Relative (-2) Row - Code: " + rs.getInt("Code") + ", Name: " + rs.getString("Name") +
                        ", Salary: " + rs.getDouble("Salary") + ", Commission: " + rs.getDouble("Commission"));
            }

            // Move to the absolute 2nd row and print the data
            if (rs.absolute(2)) {
                System.out.println("Absolute Row 2 - Code: " + rs.getInt("Code") + ", Name: " + rs.getString("Name") +
                        ", Salary: " + rs.getDouble("Salary") + ", Commission: " + rs.getDouble("Commission"));
            }

            // Move to a position before the first row
            rs.beforeFirst();
            if (rs.next()) {  // Move to the first row
                System.out.println("After beforeFirst() - Code: " + rs.getInt("Code") + ", Name: " + rs.getString("Name") +
                        ", Salary: " + rs.getDouble("Salary") + ", Commission: " + rs.getDouble("Commission"));
            }

            // Move to a position after the last row
            rs.afterLast();
            if (rs.previous()) {  // Move to the last row
                System.out.println("After afterLast() - Code: " + rs.getInt("Code") + ", Name: " + rs.getString("Name") +
                        ", Salary: " + rs.getDouble("Salary") + ", Commission: " + rs.getDouble("Commission"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
