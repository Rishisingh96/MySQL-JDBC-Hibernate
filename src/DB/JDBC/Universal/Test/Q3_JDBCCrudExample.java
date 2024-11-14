package DB.JDBC.Universal.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Q3_JDBCCrudExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/universal";
        String user = "root";
        String password = "Rishi@9838";

        Connection connection = DriverManager.getConnection(url, user, password);

        // Create
        String insertQuery = "INSERT INTO students (rno, name, marks, subject) VALUES (?, ?, ?, ?)";
        PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
        insertStmt.setInt(1, 108);
        insertStmt.setString(2, "Rishi Singh");
        insertStmt.setInt(3, 70);
        insertStmt.setString(4, "Computer Science");
        insertStmt.executeUpdate();

        // Read
       /* String selectQuery = "SELECT * FROM students";
        Statement selectStmt = connection.createStatement();
        ResultSet resultSet = selectStmt.executeQuery(selectQuery);
        while (resultSet.next()) {
            int rollNo = resultSet.getInt("rno");
            String name = resultSet.getString("name");
            int marks = resultSet.getInt("marks");
            String subject = resultSet.getString("subject");
            System.out.println("Roll No: " + rollNo + ", Name: " + name + ", Marks: " + marks + ", Subject: " + subject);
        }*/

//        // Update
       /* String updateQuery = "UPDATE students SET marks = ? WHERE rno = ?";
        PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
        updateStmt.setInt(1, 80); // Set the new marks
        updateStmt.setInt(2, 108); // Set the roll number
        updateStmt.executeUpdate();
        System.out.println("Change successfully.........");*/


        // Delete
       /* String deleteQuery = "DELETE FROM students WHERE rno = ?";
        PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery);
        deleteStmt.setInt(1, 108);
        deleteStmt.executeUpdate();
        System.out.println("delete successfully.........");*/

        // Close resources
//        resultSet.close();
//        selectStmt.close();
        insertStmt.close();
//        updateStmt.close();
//        deleteStmt.close();
        connection.close();
    }
}
