package DB.JDBC.Universal.MultipalWayConnection;

import java.sql.*;
/*3. Using PreparedStatement
This approach is useful if you want to pass parameters to your SQL queries, enhancing security and flexibility.*/
public class Using_PreparedStatement {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/universal";
        String user = "root";
        String password = "Rishi@9838";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Established.");

            String query = "SELECT * FROM student WHERE Roll_No > ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 0);  // Example parameter
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("Roll_No") + "/" +
                        resultSet.getString("Name") + "/" +
                        resultSet.getString("StreamN"));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
