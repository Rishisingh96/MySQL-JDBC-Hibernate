package DB.JDBC.Universal.ByConnectionMethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import static DB.JDBC.Universal.ByConnectionMethod.ConnectionMethod.ConnectionDB;


public class PreparedStatementExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//      Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universal", "root", "Rishi@9838");
        //ConnectionDB();

        //INSERT DATA
        try {
            Connection con = ConnectionDB();
            int Code = 29;
            String Name = "khan singh";
            double Salary = 90000;
            int Commission = 10;

            String sql = "insert into employee values(?,?,?,?)";

        PreparedStatement preparedStatement = con.prepareStatement(sql);

        preparedStatement.setInt(1,Code);
        preparedStatement.setString(2,Name);
        preparedStatement.setDouble(3,Salary);
        preparedStatement.setInt(4,Commission);

        preparedStatement.executeUpdate();
        }catch (SQLIntegrityConstraintViolationException e){
            System.out.println("Duplicate entry not allow");
        }
        System.out.println("Data Saved........");

        //FETCH DATA
       /* while (resultSet.next())
            System.out.println(resultSet.getInt("Roll_No") + "/" +
                    resultSet.getString("Name") + "/" +
                    resultSet.getString("StreamN"));*/



    }
}
