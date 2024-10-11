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
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
