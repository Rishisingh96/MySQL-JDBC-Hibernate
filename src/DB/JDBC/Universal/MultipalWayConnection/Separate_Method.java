package DB.JDBC.Universal.MultipalWayConnection;

import java.sql.*;
/*2. Using Separate Methods for Connection and Execution
This modular approach separates the concerns of connecting to the database and executing queries.*/
public class Separate_Method {
    private static final String URL = "jdbc:mysql://localhost:3306/universal";
    private static final String USER = "root";
    private static final String PASSWORD = "Rishi@9838";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            executeQuery(connection);
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void executeQuery(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("Roll_No") + "/" +
                    resultSet.getString("Name") + "/" +
                    resultSet.getString("StreamN"));
        }
        resultSet.close();
        statement.close();
    }
}
