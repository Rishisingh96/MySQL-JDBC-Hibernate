package DB.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateDemo {
    public static void main(String[] args) throws Exception {

        String city1 = "Gujarat";
        //String email1 = "rishijob@gmail.com";  //fail not match email
        String email1 = "rishicoding@gmail.com";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Rishi@9838");

        PreparedStatement preparedStatement = connection.prepareStatement("update register set city=? where email = ?");

        preparedStatement.setString(1,city1);
        preparedStatement.setString(2,email1);

        int count = preparedStatement.executeUpdate();
        if(count>0){
            System.out.println("success");
        }
        else {
            System.out.println("fail");
        }
        connection.close();

    }
}
