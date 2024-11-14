package DB.JDBC.Universal.MultipalWayConnection;
/*1. Using Try-with-Resources (Recommended)
This approach ensures that resources are automatically closed at the end of the statement.*/


import java.sql.*;

public class Try_with_Resources {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/universal";
        String user = "root";
        String password = "Rishi@9838";
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM student")
        ) {
            System.out.println("Connection Established.");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("Roll_No") + "/" +
                        resultSet.getString("Name") + "/" +
                        resultSet.getString("StreamN"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

