package dbqueries;

import com.sun.jna.platform.win32.Netapi32Util;
import org.example.User;

import java.sql.*;

import static utils.EnvProperties.*;

public class DBQueries {


    public static Connection connect() throws SQLException{
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static Integer getObjectId(String table, String param, String value){
        String selectQuery = String.format("Select * from %s where %s = '%s'", table, param, value);
        int id=0;
        try (Connection connection  = connect()){
            PreparedStatement statement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
            id = resultSet.getInt("id");
            }


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return id;
    }
}
