//package DB.JDBC.Universal.MultipalWayConnection;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class Connection_Poll {
//    private static HikariDataSource dataSource;
//
//    static {
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:mysql://localhost:3306/universal");
//        config.setUsername("root");
//        config.setPassword("Rishi@9838");
//        dataSource = new HikariDataSource(config);
//    }
//
//    public static void main(String[] args) {
//        try (Connection connection = dataSource.getConnection();
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery("SELECT * FROM student")) {
//
//            System.out.println("Connection Established.");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getInt("Roll_No") + "/" +
//                        resultSet.getString("Name") + "/" +
//                        resultSet.getString("Stream"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
