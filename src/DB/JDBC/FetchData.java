package DB.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FetchData {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Rishi@9838");
        //System.out.println("success");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from register");

        ResultSet resultSet = preparedStatement.executeQuery();
     // Only one colum print name other
       /* while (resultSet.next()){
           *//* String name1 = resultSet.getString("name");
            System.out.println(name1);*//*

            System.out.println("Name :" + resultSet.getString("name"));
        }
//        output
//        Name :Rishi
//        Name :Rishi3
        */

        while (resultSet.next()){
          String name1 = resultSet.getString("name");
          System.out.println("Name : " +name1);

            String email1 = resultSet.getString("email");
            System.out.println("Email : " +email1);

            String pass1 = resultSet.getString("password");
            System.out.println("Password : " +pass1);

            String gender1 = resultSet.getString("gender");
            System.out.println("Gender : " +gender1);

            String city1 = resultSet.getString("city");
            System.out.println("City : " +city1);

            System.out.println("------------------------------------");
        }
connection.close();
    }
}
