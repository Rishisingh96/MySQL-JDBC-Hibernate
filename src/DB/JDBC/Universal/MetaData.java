package DB.JDBC.Universal;

import java.sql.*;

import static DB.JDBC.Universal.ByConnectionMethod.ConnectionMethod.ConnectionDB;

public class MetaData {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionDB();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employee2");

        //Fetch Data
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("Id") + " | " +
                    resultSet.getString("Name") + " | " +
                    resultSet.getString("Post") + " | " +
                    resultSet.getDouble("Salary") + " | " +
                    resultSet.getInt("DepartNo"));
        }

        //we can fetch table label information in our application using resultSet metadata object
        ResultSetMetaData result = resultSet.getMetaData();
        for (int i = 1; i < result.getColumnCount(); i++) {
            System.out.println(result.getColumnName(i) + " ");
            System.out.println(result.getColumnTypeName(i) + " ");
            System.out.println(result.getColumnDisplaySize(i) + " ");
        }
    }
}