package DB.JDBC.Universal.Week2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultSetMetaDataDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/universal"; // Your DB URL
        String username = "root"; // Your DB username
        String password = "Rishi@9838"; // Your DB password

        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement()) {

            // Execute the query and get the ResultSet
            String query = "SELECT * FROM Student";
            ResultSet rs = stmt.executeQuery(query);

            // Get the ResultSetMetaData object
            ResultSetMetaData rsmd = rs.getMetaData();

            // Get and print the number of columns
            int columnCount = rsmd.getColumnCount();
            System.out.println("Total Columns: " + columnCount);

            // Iterate over each column and print metadata information
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + ":");
                System.out.println(" - Name: " + rsmd.getColumnName(i));
                System.out.println(" - Type: " + rsmd.getColumnTypeName(i));
                System.out.println(" - Size: " + rsmd.getColumnDisplaySize(i));
                System.out.println(" - Nullable: " + (rsmd.isNullable(i) == ResultSetMetaData.columnNullable ? "Yes" : "No"));
                System.out.println(" - Auto Increment: " + (rsmd.isAutoIncrement(i) ? "Yes" : "No"));
                System.out.println(" - Read-Only: " + (rsmd.isReadOnly(i) ? "Yes" : "No"));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
