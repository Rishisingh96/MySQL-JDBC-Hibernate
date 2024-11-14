package DB.JDBC.Universal.Week2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeCRUDUsingScrollableResultSet {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/universal"; // Your DB URL
        String username = "root"; // Your DB username
        String password = "Rishi@9838"; // Your DB password

        try (Connection con = DriverManager.getConnection(url, username, password)) {

            // 1. Create - Insert a new employee
            String insertSQL = "INSERT INTO Employee3(empid, emp_name, emp_dept, emp_salary) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(insertSQL)) {
                pstmt.setInt(1, 101);
                pstmt.setString(2, "Alice");
                pstmt.setString(3, "HR");
                pstmt.setDouble(4, 55000.00);
                pstmt.executeUpdate();
                System.out.println("Inserted record into the Employee table...");
            }

            // 2. Read - Select all employees using Scrollable and Updatable ResultSet
            String selectSQL = "SELECT empid, emp_name, emp_dept, emp_salary FROM Employee3";
            try (Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                 ResultSet rs = stmt.executeQuery(selectSQL)) {

                // Move cursor to the last row
                if (rs.last()) {
                    System.out.println("Last Employee Details: ");
                    System.out.println("ID: " + rs.getInt("empid") +
                            ", Name: " + rs.getString("emp_name") +
                            ", Dept: " + rs.getString("emp_dept") +
                            ", Salary: " + rs.getDouble("emp_salary"));
                }

                // Move cursor to the first row
                if (rs.first()) {
                    System.out.println("First Employee Details: ");
                    System.out.println("ID: " + rs.getInt("empid") +
                            ", Name: " + rs.getString("emp_name") +
                            ", Dept: " + rs.getString("emp_dept") +
                            ", Salary: " + rs.getDouble("emp_salary"));
                }

                // Move to a specific row and update
                if (rs.absolute(1)) {
                    rs.updateDouble("emp_salary", 60000.00);
                    rs.updateRow();
                    System.out.println("Updated Employee Salary on the first row.");
                }
            }

            // 3. Update - Using PreparedStatement
            String updateSQL = "UPDATE Employee3 SET emp_dept = ? WHERE empid = ?";
            try (PreparedStatement pstmt = con.prepareStatement(updateSQL)) {
                pstmt.setString(1, "Finance");
                pstmt.setInt(2, 101);
                pstmt.executeUpdate();
                System.out.println("Updated Employee department...");
            }

            // 4. Delete - Using PreparedStatement
            String deleteSQL = "DELETE FROM Employee3 WHERE empid = ?";
            try (PreparedStatement pstmt = con.prepareStatement(deleteSQL)) {
                pstmt.setInt(1, 101);
                pstmt.executeUpdate();
                System.out.println("Deleted Employee record...");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
