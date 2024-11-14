package DB.JDBC.Universal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static DB.JDBC.Universal.ByConnectionMethod.ConnectionMethod.ConnectionDB;

public class Fetch_and_Insert_Data {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//      Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universal", "root", "Rishi@9838");
      //ConnectionDB();
      Connection con = ConnectionDB();
      //INSERT DATA
        int Code = 24;
        String Name = "Mohit";
        double Salary = 70000.00;
        double Commission  = 20;

        String sql = "insert into employee values(?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);

        preparedStatement.setInt(1,Code);
        preparedStatement.setString(2,Name);
        preparedStatement.setDouble(3,Salary);
        preparedStatement.setDouble(4,Commission);

        preparedStatement.executeUpdate();
        System.out.println("Data Saved........");

        //FETCH DATA
     /*   while (rs.next())
            System.out.println(resultSet.getInt("Roll_No") + "/" +
                    resultSet.getString("Name") + "/" +
                    resultSet.getString("StreamN"));
 */

        con.close();

    }
}
