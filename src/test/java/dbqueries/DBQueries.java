package dbqueries;

import com.sun.jna.platform.win32.Netapi32Util;
import org.example.User;

import java.sql.*;

public class DBQueries {

    private final static String URL="jdbc:mariadb://localhost:3306/kanboard";
    private final static String USER= "kanboard";
    private final static String PASSWORD= "kanboard-secret";

    public static Connection connect() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static String getName(){
        String selectQuery = String.format("Select * from users where email = 'alex@alex.test'");
        String name = "temp";
        try (Connection connection  = connect()){
            PreparedStatement statement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
            name = resultSet.getString("name");
            }


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return name;
    }

    public static void main(String[] args) {
        System.out.println(getName());
    }


}
