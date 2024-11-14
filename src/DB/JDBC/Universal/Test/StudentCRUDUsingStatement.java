package DB.JDBC.Universal.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentCRUDUsingStatement {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/universal"; // Your DB URL
        String username = "root"; // Your DB username
        String password = "Rishi@9838"; // Your DB password

        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement()) {

            // 1. Create - Insert a new student
            String insertSQL = "INSERT INTO student3 (rno, name, marks, subject) VALUES (10, 'John Doe', 85, 'Mathematics')";
            stmt.executeUpdate(insertSQL);
            System.out.println("Inserted record into the table...");

            // 2. Read - Select students from the table
            String selectSQL = "SELECT * FROM student3";
            ResultSet rs = stmt.executeQuery(selectSQL);
            while (rs.next()) {
                System.out.println("Roll No: " + rs.getInt("rno") + ", Name: " + rs.getString("name") +
                        ", Marks: " + rs.getInt("marks") + ", Subject: " + rs.getString("subject"));
            }

            // 3. Update - Update a student's marks
            String updateSQL = "UPDATE student3 SET marks = 90 WHERE rno = 1";
            stmt.executeUpdate(updateSQL);
            System.out.println("Updated record in the table...");

            // 4. Delete - Delete a student record
            String deleteSQL = "DELETE FROM student3 WHERE rno = 1";
            stmt.executeUpdate(deleteSQL);
            System.out.println("Deleted record from the table...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/*Inserted record into the table...
Roll No: 1, Name: John Doe, Marks: 85, Subject: Mathematics
Roll No: 2, Name: Jane Smith, Marks: 92, Subject: Physics
Roll No: 4, Name: Garima , Marks: 70, Subject: Baio
Roll No: 10, Name: John Doe, Marks: 85, Subject: Mathematics
Roll No: 22, Name: Rishi singh , Marks: 80, Subject: Math
Updated record in the table...
Deleted record from the table...
*/