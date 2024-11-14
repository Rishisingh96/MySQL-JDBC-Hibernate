package DB.JDBC.Universal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import static DB.JDBC.Universal.ByConnectionMethod.ConnectionMethod.ConnectionDB;

public class WhichRecodeRepeated {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionDB();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employee2");

        // search same name
//        String ename = "Rishi Singh";
//        while (resultSet.next()) {
//            if(resultSet.getString("Name").equals(ename)){
//                System.out.println(resultSet.getInt("Id")+" | "+
//                        resultSet.getString("Name")+" | "+
//                        resultSet.getString("Post")+" | "+
//                        resultSet.getDouble("Salary")+" | "+
//                        resultSet.getInt("DepartNo"));
//            }
//        }
        //Question:1 Check Which record is repeated
        //resultSet.first();
        // Use a HashMap to count occurrences of each name

        Map<String, Integer> nameCount = new HashMap<>();
        while (resultSet.next()) {
            String ename = resultSet.getString("Name");
            nameCount.put(ename, nameCount.getOrDefault(ename, 0) + 1);
        }

        // Reset cursor to the beginning of the result set
        resultSet.beforeFirst();

        // Print repeated names with their details
        System.out.println("Id | Name | Post | Salary | DepartNo");
        while (resultSet.next()) {
            String ename = resultSet.getString("Name");
            if (nameCount.get(ename) > 1) {
                System.out.println(resultSet.getInt("Id") + " | " +
                        resultSet.getString("Name") + " | " +
                        resultSet.getString("Post") + " | " +
                        resultSet.getDouble("Salary") + " | " +
                        resultSet.getInt("DepartNo"));
            }
        }

        // Print the count of repeated names
        System.out.println("\nRepeated Names and their counts:");
        for (Map.Entry<String, Integer> entry : nameCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Name: " + entry.getKey() + ", RepetitionCount: " + entry.getValue());
            }
        }

        //Question 2
    }
}
