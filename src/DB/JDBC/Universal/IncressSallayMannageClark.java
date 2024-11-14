package DB.JDBC.Universal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static DB.JDBC.Universal.ByConnectionMethod.ConnectionMethod.ConnectionDB;

public class IncressSallayMannageClark {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionDB();
        Statement stmt = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM employee2");

        System.out.println("Id | Name | Post | Salary | DepartNo");
        while (rs.next()) {
            if(rs.getString("Post").equalsIgnoreCase("Manager")){
                Double up = rs.getDouble("Salary")+rs.getDouble("Salary")*20/100;
                rs.updateDouble("Salary",up);
                rs.updateRow();
            }
            if(rs.getString("Post").equalsIgnoreCase("Clark")){
                Double cl = rs.getDouble("Salary")+rs.getDouble("Salary")*10/100;
                rs.updateDouble("Salary",cl);
                rs.updateRow();
            }
                System.out.println(rs.getInt("Id") + " | " +
                        rs.getString("Name") + " | " +
                        rs.getString("Post") + " | " +
                        rs.getDouble("Salary") + " | " +
                        rs.getInt("DepartNo"));
        }
    }
}
