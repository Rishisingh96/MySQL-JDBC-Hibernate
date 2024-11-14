package DB.JDBC.Universal;

import java.sql.*;
import java.util.Scanner;

public class Student_Featch_Data {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/universal", "root", "Rishi@9838");
        System.out.println("Connection Establish.");

        // Fetch all data
     /*   Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from student");
        while (resultSet.next())
            System.out.println(resultSet.getInt("Roll_No") + "/" +
                    resultSet.getString("Name") + "/" +
                    resultSet.getString("StreamN"));*/

        //second : Fetch  Name all detials
      /*  System.out.println("Enter your Name:");
        Scanner in = new Scanner(System.in);

        String ename = in.nextLine();

        String sql = "select * from student where Name= ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, ename);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("Roll_No") + "/" +
                    resultSet.getString("Name") + "/" +
                    resultSet.getString("StreamN"));

        }*/

        //Delete
        System.out.println("Enter your Name:");
        Scanner in = new Scanner(System.in);

        String ename = in.nextLine();

        String sql = "select * from student where Name= ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, ename);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("Roll_No") + "/" +
                    resultSet.getString("Name").toUpperCase() + "/" +
                    resultSet.getString("StreamN"));
        }
       connection.close();
    }
}

/*

Connection connection = null;
        try{

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/universal" ,"root","Rishi@9838");
            System.out.println("Connection Establish.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                connection.close();
            }
        }

        */
