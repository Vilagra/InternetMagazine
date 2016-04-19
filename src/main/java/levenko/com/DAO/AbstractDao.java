package levenko.com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Vilagra on 28.03.2016.
 */

public abstract class AbstractDao {
    private static final String URL = "jdbc:mysql://localhost:3306/mywebshop?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Connection connection;

    public Connection getConnection() {
        try{
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  connection;
    }


}
