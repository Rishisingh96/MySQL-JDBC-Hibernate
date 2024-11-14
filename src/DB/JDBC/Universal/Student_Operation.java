package DB.JDBC.Universal;

import java.sql.*;
import java.util.Scanner;

public class Student_Operation {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/universal", "root", "Rishi@9838");
        System.out.println("Connection Establish.");

        Statement statement = connection.createStatement();
     //  ResultSet resultSet = statement.executeQuery("select * from student");

        //first way
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM student WHERE Roll_No = 36");
//        if (resultSet.next()) {
//            System.out.println(resultSet.getInt("Roll_No") + "/" +
//                    resultSet.getString("Name") + "/" +
//                    resultSet.getString("StreamN"));
//        } else {
//            System.out.println("Not found !!");
//        }

        //second way
      /*  boolean found = false;
        while (resultSet.next()) {
            if (resultSet.getInt("Roll_No") == 36) {
                System.out.println(resultSet.getInt("Roll_No") + "/" +
                        resultSet.getString("Name") + "/" +
                        resultSet.getString("StreamN"));
                found = true;
                break; // Exit the loop once the desired record is found
            }
        }

        if (!found) {
            System.out.println("Not found !!");
        }*/

        // find string
        /*boolean found = false;
        while (resultSet.next()) {
            if (resultSet.getString("StreamN").equals("Computer Science")) {
                System.out.println(resultSet.getInt("Roll_No") + "/" +
                        resultSet.getString("Name") + "/" +
                        resultSet.getString("StreamN"));
                found = true;
                break; // Exit the loop once the desired record is found
            }
        }

        if (!found) {
            System.out.println("Not found !!");
        }*/

        //feach all

       /* String sql = "SELECT * FROM student WHERE StreamN = 'Computer Science'";
        ResultSet resultSet1 = statement.executeQuery(sql);

        boolean found = false;
        while (resultSet1.next()) {
            System.out.println(resultSet1.getInt("Roll_No") + "/" +
                    resultSet1.getString("Name") + "/" +
                    resultSet1.getString("StreamN"));
            found = true;
        }

        if (!found) {
            System.out.println("No Computer Science students found !!");
        }*/

        //add salary

       /* boolean found = false;
        int salary = 0;
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("Roll_No") + "/" +
                    resultSet.getString("Name") + "/" +
                    resultSet.getString("StreamN"));
            salary = salary + resultSet.getInt("Roll_No");
            found = true;
        }
        System.out.println(salary);
        if (!found) {
            System.out.println("No Computer Science students found !!");
        }*/
        System.out.println("Enter your Name:");
        Scanner in = new Scanner(System.in);
        String roll_no = in.nextLine();

        // SQL DELETE query
        String sql = "DELETE FROM student WHERE Roll_No = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, roll_no);

        // Execute the DELETE query
        int rowsAffected = preparedStatement.executeUpdate();

        // Provide feedback based on the result
        if (rowsAffected > 0) {
            System.out.println("Deletion successful.");
        } else {
            System.out.println("No student found with Roll Number: " + roll_no);
        }

        // Close the resources
        preparedStatement.close();
        connection.close();
    }
}
