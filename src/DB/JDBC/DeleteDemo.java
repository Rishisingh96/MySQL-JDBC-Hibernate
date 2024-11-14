package DB.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteDemo {
    String email = "rishicoding9838@gmail.com";


    public static void main(String[] args) throws Exception {
        String email1 = "rishi@gmail.com";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Rishi@9838");

        PreparedStatement preparedStatement = connection.prepareStatement("delete from register where email=?");
        preparedStatement.setString(1,email1);

        int count = preparedStatement.executeUpdate();
        if (count>0){
            System.out.println("deletion success");
        }
        else {
            System.out.println("deletion failed");
        }
    }

}
