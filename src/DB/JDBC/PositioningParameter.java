package DB.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PositioningParameter {
    public static void main(String[] args) throws Exception{
        String name1 = "Rishi3";
        String email1 = "rishicoding9838@gmail.com";
        String pass1 = "rishi9170";
        String gender1 = "Male";
        String city1 = "Ayodhya";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Rishi@9838");
        System.out.println("success");
        PreparedStatement preparedStatement = connection.prepareStatement("insert into register values(?,?,?,?,?)");
        preparedStatement.setString(1,name1);
        preparedStatement.setString(2,email1);
        preparedStatement.setString(3,pass1);
        preparedStatement.setString(4,gender1);
        preparedStatement.setString(5,city1);

        int i = preparedStatement.executeUpdate();
        if(i>0){
            System.out.println("success");
        }
        else {
            System.out.println("fail");
        }
    }
}
