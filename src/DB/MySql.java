package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySql {
    public static void main(String[] args) throws Exception {
        try{
            String url = "jdbc:mysql://localhost:3306/";

            String databaseName = "rishi";
            String username = "root";
            String password = "Rishi@9838";

            Connection connection = DriverManager.getConnection(url , username , password);
            System.out.println("Connected successfully");
            String sql = "CREATE DATABASE " + databaseName;

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        }
    }


