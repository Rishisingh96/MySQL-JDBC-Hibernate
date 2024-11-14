package DB.JDBC.Universal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static DB.JDBC.Universal.ByConnectionMethod.ConnectionMethod.ConnectionDB;

public class WhichRecordRepeated2 {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionDB();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employee2");

        // List to store names
        List<String> names = new ArrayList<>();

        // Collect all names
        while (resultSet.next()) {
            names.add(resultSet.getString("Name"));
        }

        // Reset cursor to the beginning of the result set
        resultSet.beforeFirst();

        // Print repeated names with their details
        System.out.println("Id | Name | Post | Salary | DepartNo");
        while (resultSet.next()) {
            String ename = resultSet.getString("Name");
            int count = 0;
            // Count occurrences of the current name
            for (String name : names) {
                if (name.equals(ename)) {
                    count++;
                }
            }
            // Print details if the name is repeated
            if (count > 1) {
                System.out.println(resultSet.getInt("Id") + " | " +
                        resultSet.getString("Name") + " | " +
                        resultSet.getString("Post") + " | " +
                        resultSet.getDouble("Salary") + " | " +
                        resultSet.getInt("DepartNo"));
            }
        }

        // Reset cursor to the beginning of the result set
     //   resultSet.beforeFirst();

        // Print the count of repeated names
        System.out.println("\nRepeated Names and their counts:");
        List<String> printedNames = new ArrayList<>();
        while (resultSet.next()) {
            String ename = resultSet.getString("Name");
            if (!printedNames.contains(ename)) {
                int count = 0;
                // Count occurrences of the current name
                for (String name : names) {
                    if (name.equals(ename)) {
                        count++;
                    }
                }
                if (count > 1) {
                    System.out.println("Name: " + ename + ", RepetitionCount: " + count);
                    printedNames.add(ename);
                }
            }
        }

        connection.close();
    }
}
