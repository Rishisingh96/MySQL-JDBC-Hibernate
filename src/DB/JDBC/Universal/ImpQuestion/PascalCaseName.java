package DB.JDBC.Universal.ImpQuestion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static DB.JDBC.Universal.ByConnectionMethod.ConnectionMethod.ConnectionDB;
public class PascalCaseName {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionDB();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery("Select * from student1");

        if(resultSet.absolute(2)) {
            //System.out.println();

            String[] words = resultSet.getString("Name").split(" ");
            StringBuilder pascalCS = new StringBuilder();
            for (String word : words) {
                pascalCS.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase() + " ");
            }
            System.out.println(pascalCS);
        }
    }
}
 /*           if( resultSet.first()){
//            System.out.println(resultSet.getString("Name").toUpperCase());
//            System.out.println(resultSet.getString("Name").toUpperCase());
            }
//        if(resultSet.absolute(2)){
//            System.out.println(resultSet.getString("Name").);
//        }

        String name = "bob Singh";
        String[] words = name.split(" ");
//        System.out.println(name.toUpperCase());
       for (String namec:words){
        //pp   if(namec.charAt(0))
           System.out.println(namec);
       }
        System.out.println(name);
     //   String result =toCamelCase(name);
       // System.out.println(name);
//        System.out.println(name.toUpperCase().charAt(0)+name);
    }*/
//    public static String toCamelCase(String  name){
////        String na = name.split();
////
//        return name;
//    }

