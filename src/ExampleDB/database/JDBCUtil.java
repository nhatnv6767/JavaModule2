package ExampleDB.database;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection() {
        Connection c = null;

        try {
            // register JDBC driver voi DriverManager
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            String url = "jdbc:mysql://192.168.1.113:3306/onTap";
            String username = "root";
            String password = "123456";
            // tao ket noi
            c = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    public static void closeConnection(Connection c) {

    }
}
