package DB.JDBC.Universal;

import java.sql.*;

public class ScrollableResultSetQuestion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/universal";
        String user = "root";
        String password = "Rishi@9838";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement(
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
//                     ResultSet.CONCUR_READ_ONLY);
                     ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery("SELECT * FROM employee")){

            // Use Move Forward method TYPE_SCROLL METHOD TO FETCH DATA FROM SPECIFIC PLACE ANYWHERE
//            rs.absolute(2);
//            System.out.println("First Row - Code: " + rs.getInt("Code") + ", Name: " + rs.getString("Name") +
//                    ", Salary: " + rs.getDouble("Salary") + ", Commission: " + rs.getDouble("Commission"));
//
//            rs.updateString("Name","Mohan");
//            rs.updateRow();
//
            //Details using code
//            System.out.println("Enter your Code and update your salary ");
//            Scanner scanner = new Scanner(System.in);
//            int code = scanner.nextInt();
//            while (rs.next()){
//                if(rs.getInt("Code") ==code){
//                    System.out.println("First Row - Code: " + rs.getInt("Code") + ", Name: " + rs.getString("Name") +
//                            ", Salary: " + rs.getDouble("Salary") + ", Commission: " + rs.getDouble("Commission"));
//                }
//            }

            //Q 0 - Update Salary using code number -
           /* System.out.println("Enter your Code and update your salary ");
            Scanner scanner = new Scanner(System.in);
            int code = scanner.nextInt();
            while (rs.next()){
                if(rs.getInt("Code") ==code){
                    System.out.println("Before Salary Update- Code: " + rs.getInt("Code") + ", Name: " + rs.getString("Name") +
                            ", Salary: " + rs.getDouble("Salary") + ", Commission: " + rs.getDouble("Commission"));

                    rs.updateInt("Salary",80000);
                    rs.updateRow();

                    System.out.println("Ofter Salary Update - Code: " + rs.getInt("Code") + ", Name: " + rs.getString("Name") +
                            ", Salary: " + rs.getDouble("Salary") + ", Commission: " + rs.getDouble("Commission"));

                }
            }*/

            // Que1 - Read the code value from the user 107 update Salary (7000) increasing 20000(20%)
          /*  System.out.println("Enter your Code and update your salary ");
            Scanner scanner = new Scanner(System.in);
            int code = scanner.nextInt();
            while (rs.next()){
                if(rs.getInt("Code") ==code){
                    System.out.println("Before Salary Update- Code: " + rs.getInt("Code") + ", Name: " + rs.getString("Name") +
                            ", Salary: " + rs.getDouble("Salary") + ", Commission: " + rs.getDouble("Commission"));
                       Double to = rs.getDouble("Salary")- rs.getDouble("Salary")*5/100;
                    rs.updateDouble("Salary",to);
                    rs.updateRow();

                    System.out.println("Ofter Salary Update - Code: " + rs.getInt("Code") + ", Name: " + rs.getString("Name") +
                    ", Salary: " + rs.getDouble("Salary") + ", Commission: " + rs.getDouble("Commission"));

                }
            }*/

//            while (rs.next()){
//                if(rs.getString("Name").equals("Roll_No")){
//                    rs.updateDouble("Salary",20000);
//                    rs.updateRow();
//                    break;
//                }
//            }

//            if(rs.first()){
//                System.out.println("First Row - Code: " + rs.getInt("Code") + ", Name: " + rs.getString("Name") +
//                        ", Salary: " + rs.getDouble("Salary") + ", Commission: " + rs.getDouble("Commission"));
//            }
//            if (rs.relative(4)){
//                System.out.println("Relative - Code: " + rs.getInt("Code") + ", Name: " + rs.getString("Name") +
//                        ", Salary: " + rs.getDouble("Salary") + ", Commission: " + rs.getDouble("Commission"));
//            }


            //increase all salary 5%
            while (rs.next()) {
                    System.out.println("Before Salary Update- Code: " + rs.getInt("Code") + ", Name: " + rs.getString("Name") +
                            ", Salary: " + rs.getDouble("Salary") + ", Commission: " + rs.getDouble("Commission")+"%");

                    Double to = rs.getDouble("Salary") + rs.getDouble("Salary") * rs.getDouble("Commission")/100;
                    rs.updateDouble("Salary", to);
                    rs.updateRow();

                    System.out.println("Ofter Salary Update - Code: " + rs.getInt("Code") + ", Name: " + rs.getString("Name") +
                            ", Salary: " + rs.getDouble("Salary") + ", Commission: " + rs.getDouble("Commission")+"%");

                System.out.println("\n");
            }

                }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
