package DB.JDBC.Universal.MultipalWayConnection;

import java.sql.*;

public class simpleTryCatchFinaly {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        try{

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/universal" ,"root","Rishi@9838");
            System.out.println("Connection Establish.");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next())
                System.out.println(resultSet.getInt("Roll_No") + "/" + resultSet.getString("Name") + "/" + resultSet.getString("StreamN"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                connection.close();
            }
        }
    }
}


