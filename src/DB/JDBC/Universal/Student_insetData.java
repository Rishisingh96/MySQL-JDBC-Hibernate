package DB.JDBC.Universal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Student_insetData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/universal","root","Rishi@9838");
        System.out.println("Connection Establish.........");

        //first Way
  /*      int Roll_No = 34;
        String Name = "Suman";
        String StreamN = "House Wife";

        String sql = "insert into student values(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,Roll_No);
        preparedStatement.setString(2,Name);
        preparedStatement.setString(3,StreamN);

        preparedStatement.executeUpdate();
        System.out.println("Data Saved........");
*/


        //second Way ..........................
      /*  Statement statement = connection.createStatement();
        String sql = "INSERT INTO student (Roll_No, Name, StreamN) VALUES (" + Roll_No + ", '" + Name + "', '" + StreamN + "')";
        statement.executeUpdate(sql);

        System.out.println("Data Saved........");*/




        //input by user
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Roll no:");
        int Roll_No = in.nextInt();
        in.nextLine();  // Consume the leftover newline character

        System.out.println("Enter the Name:");
        String Name = in.nextLine();

        System.out.println("Enter the Stream name:");
        String StreamN = in.nextLine();

        String sql = "insert into student values(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,Roll_No);
        preparedStatement.setString(2,Name);
        preparedStatement.setString(3,StreamN);

        preparedStatement.executeUpdate();
        System.out.println("Data Saved........");
        connection.close();

    }
}
/*
mysql> select * from student;
+---------+---------------+------------------------+
| Roll_No | Name          | StreamN                |
+---------+---------------+------------------------+
|       1 | Rishi         | Computer Science       |
|      30 | John Doe      | Computer Science       |
|      31 | Jane Smith    | Mechanical Engineering |
|      32 | Alice Johnson | Electrical Engineering |
+---------+---------------+------------------------+
4 rows in set (0.02 sec)*/
