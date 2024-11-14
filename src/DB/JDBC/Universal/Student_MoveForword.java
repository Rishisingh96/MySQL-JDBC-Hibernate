package DB.JDBC.Universal;

import java.sql.*;
public class Student_MoveForword {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/universal", "root", "Rishi@9838");

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery("select * from students");

//        INSERT DATA
        int Code = 20;
        String Name = "Rishi";
        double Salary = 50000.23;
        double Commission  = 10;

        //FETCH DATA
        while (resultSet.next())
            System.out.println(resultSet.getInt("Roll_No") + "/" +
                    resultSet.getString("Name") + "/" +
                    resultSet.getString("StreamN"));

        // Use Move Forward method TYPE_SCROLL METHOD TO FETCH DATA FROM SPECIFIC PLACE ANYWHERE
        resultSet.absolute(2);
        System.out.println(resultSet.getInt("Roll_No") + "/" +
                resultSet.getString("Name") + "/" +
                resultSet.getString("StreamN"));
        resultSet.updateString("Name","Mohan");
        resultSet.updateRow();

        // Que1 - Read the code value from the user 107 update Salary (7000) increasing 20000(20%)
        while (resultSet.next()){
            if(resultSet.getString("Name").equals("Roll_No")){
//                resultSet.updateDouble("Salary",20000);
                resultSet.updateDouble("Salary",20000);
                resultSet.updateRow();
                break;
            }
         }
        //Que2 - increase all salary 10%
        //Que3 - increase only |Animal -> manager| to 20%

        connection.close();
    }
}
