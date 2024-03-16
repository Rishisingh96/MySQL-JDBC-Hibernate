package DB.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDemo {
    public static void main(String[] args) throws Exception{
//        class.forName("com.mysql.cj.jdbc.Driver"); //Error
      //1 method using try catch 2- use throw keyword
      /*  try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }*/

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Rishi@9838");
//        System.out.println("success fully loaded ");

        PreparedStatement preparedStatement = connection.prepareStatement("insert into register value('Rishi','rishi@gmail.com','rishi9696','male','Basti')");
        int i = preparedStatement.executeUpdate();
        if(i>0){
            System.out.println("success");
        }
        else {
            System.out.println("fail");
        }
    }
}
