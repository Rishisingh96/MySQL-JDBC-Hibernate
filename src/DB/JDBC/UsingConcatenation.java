package DB.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public  class UsingConcatenation {
    public static void main(String[] args) throws Exception {
         String name1 = "Rishi2";
        String email1 = "rishicoding@gmail.com";
        String pass1 = "rishi9838";
        String gender = "Male";
        String city1 = "mubmbai";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Rishi@9838");
            System.out.println("success");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into register value('"+name1+"','"+email1+"','"+pass1+"','"+gender+"','"+city1+"')");
            int i = preparedStatement.executeUpdate();
            if(i>0){
                System.out.println("success");
            }
            else {
                System.out.println("fail");
            }
    }


}
