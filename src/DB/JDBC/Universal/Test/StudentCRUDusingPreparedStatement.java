package DB.JDBC.Universal.Test;

import java.sql.*;
import java.util.Scanner;

public class StudentCRUDusingPreparedStatement {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/universal";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Rishi@9838";


    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Choose an operation:");
                System.out.println("1. Create a new student");
                System.out.println("2. Read all students");
                System.out.println("3. Update a student");
                System.out.println("4. Delete a student");
                System.out.println("5. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        createStudent(connection, scanner);
                        break;
                    case 2:
                        readStudents(connection);
                        break;
                    case 3:
                        updateStudent(connection, scanner);
                        break;
                    case 4:
                        deleteStudent(connection, scanner);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createStudent(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter roll number: ");
        int rno = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter subject: ");
        String subject = scanner.nextLine();

        String sql = "INSERT INTO student3 (rno, name, marks, subject) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, rno);
            pstmt.setString(2, name);
            pstmt.setDouble(3, marks);
            pstmt.setString(4, subject);
            pstmt.executeUpdate();
            System.out.println("Student added successfully.");
        }
    }

    private static void readStudents(Connection connection) throws SQLException {
        String sql = "SELECT * FROM student3";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int rno = rs.getInt("rno");
                String name = rs.getString("name");
                double marks = rs.getDouble("marks");
                String subject = rs.getString("subject");
                System.out.println("Roll Number: " + rno + ", Name: " + name + ", Marks: " + marks + ", Subject: " + subject);
            }
        }
    }

    private static void updateStudent(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter roll number of student to update: ");
        int rno = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new subject: ");
        String subject = scanner.nextLine();

        String sql = "UPDATE student3 SET name = ?, marks = ?, subject = ? WHERE rno = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, marks);
            pstmt.setString(3, subject);
            pstmt.setInt(4, rno);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student not found.");
            }
        }
    }

    private static void deleteStudent(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter roll number of student to delete: ");
        int rno = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String sql = "DELETE FROM student3 WHERE rno = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, rno);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }
        }
    }
}
/*"C:\Users\Rishi singh\.jdks\openjdk-21.0.2\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.3.4\lib\idea_rt.jar=55378:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.3.4\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath E:\Hybernate-JDBC-MYSQL\MySQL-JDBC-Hibernate\out\production\MySQL-JDBC-Hibernate;E:\Hybernate-JDBC-MYSQL\MySQL-JDBC-Hibernate\lib\Hibernate\angus-activation-2.0.0.jar;E:\Hybernate-JDBC-MYSQL\MySQL-JDBC-Hibernate\lib\Hibernate\antlr4-runtime-4.13.0.jar;E:\Hybernate-JDBC-MYSQL\MySQL-JDBC-Hibernate\lib\Hibernate\byte-buddy-1.14.11.jar;E:\Hybernate-JDBC-MYSQL\MySQL-JDBC-Hibernate\lib\Hibernate\classmate-1.5.1.jar;E:\Hybernate-JDBC-MYSQL\MySQL-JDBC-Hibernate\lib\Hibernate\hibernate-commons-annotations-6.0.6.Final.jar;E:\Hybernate-JDBC-MYSQL\MySQL-JDBC-Hibernate\lib\Hibernate\hibernate-core-6.4.4.Final.jar;E:\Hybernate-JDBC-MYSQL\MySQL-JDBC-Hibernate\lib\Hibernate\istack-commons-runtime-4.1.1.jar;E:\Hybernate-JDBC-MYSQL\MySQL-JDBC-Hibernate\lib\Hibernate\jakarta.activation-api-2.1.0.jar;E:\Hybernate-JDBC-MYSQL\MySQL-JDBC-Hibernate\lib\Hibernate\jakarta.inject-api-2.0.1.jar;E:\Hybernate-JDBC-MYSQL\MySQL-JDBC-Hibernate\lib\Hibernate\jakarta.persistence-api-3.1.0.jar;E:\Hybernate-JDBC-MYSQL\MySQL-JDBC-Hibernate\lib\Hibernate\jakarta.transaction-api-2.0.1.jar;E:\Hybernate-JDBC-MYSQL\MySQL-JDBC-Hibernate\lib\Hibernate\jakarta.xml.bind-api-4.0.0.jar;E:\Hybernate-JDBC-MYSQL\MySQL-JDBC-Hibernate\lib\Hibernate\jandex-3.1.2.jar;E:\Hybernate-JDBC-MYSQL\MySQL-JDBC-Hibernate\lib\Hibernate\jaxb-core-4.0.2.jar;E:\Hybernate-JDBC-MYSQL\MySQL-JDBC-Hibernate\lib\Hibernate\jaxb-runtime-4.0.2.jar;E:\Hybernate-JDBC-MYSQL\MySQL-JDBC-Hibernate\lib\Hibernate\jboss-logging-3.5.0.Final.jar;E:\Hybernate-JDBC-MYSQL\MySQL-JDBC-Hibernate\lib\Hibernate\txw2-4.0.2.jar;E:\Hybernate-JDBC-MYSQL\MySQL-JDBC-Hibernate\lib\MySql_Connector\mysql_1_-connector-j-8.3.0.jar DB.JDBC.Universal.Test.StudentCRUDusingPreparedStatement
Choose an operation:
1. Create a new student
2. Read all students
3. Update a student
4. Delete a student
5. Exit
1
Enter roll number: 21
Enter name: Mohit
Enter marks: 70
Enter subject: computer Science
Student added successfully.
Choose an operation:
1. Create a new student
2. Read all students
3. Update a student
4. Delete a student
5. Exit
2
Roll Number: 2, Name: Jane Smith, Marks: 92.0, Subject: Physics
Roll Number: 4, Name: Garima , Marks: 70.0, Subject: Baio
Roll Number: 10, Name: John Doe, Marks: 85.0, Subject: Mathematics
Roll Number: 21, Name: Mohit, Marks: 70.0, Subject: computer Science
Roll Number: 22, Name: Rishi singh , Marks: 80.0, Subject: Math
Choose an operation:
1. Create a new student
2. Read all students
3. Update a student
4. Delete a student
5. Exit
3
Enter roll number of student to update: 22
Enter new name: Rishi Rajput
Enter new marks: 85
Enter new subject: Computer Science
Student updated successfully.
Choose an operation:
1. Create a new student
2. Read all students
3. Update a student
4. Delete a student
5. Exit
4
Enter roll number of student to delete: 10
Student deleted successfully.
Choose an operation:
1. Create a new student
2. Read all students
3. Update a student
4. Delete a student
5. Exit
2
Roll Number: 2, Name: Jane Smith, Marks: 92.0, Subject: Physics
Roll Number: 4, Name: Garima , Marks: 70.0, Subject: Baio
Roll Number: 21, Name: Mohit, Marks: 70.0, Subject: computer Science
Roll Number: 22, Name: Rishi Rajput, Marks: 85.0, Subject: Computer Science
Choose an operation:
1. Create a new student
2. Read all students
3. Update a student
4. Delete a student
5. Exit
5
*/