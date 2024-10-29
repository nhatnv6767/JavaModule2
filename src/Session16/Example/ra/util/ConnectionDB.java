package Session16.Example.ra.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    /*
    1. URL cua CSDL can ket noi den
        - address Server cai` CSDL
        - Database name
        - port: 3306
    2. Driver cua CSDL MySQL
    3. Username va Password
    * */

    private static final String URL = "jdbc:mysql://192.168.1.113:3306/EcommerceDB";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "123456";

    // Phuong thuc mo ket noi va tao doi tuong Connection de lam viec voi db
    public static Connection openConnection() {

        Connection conn = null;
        try {
            // 1. Set Driver cho DriverManager
            Class.forName(DRIVER);
            // 2. Khoi tao doi tuong Connection tu DriverManager
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // 3. Tra ve doi tuong Connection
        return conn;
    }

    // Phuong thuc dong connection, callableStatement
    public static void closeConnection(Connection conn, CallableStatement callableStatement) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (callableStatement != null) {
            try {
                callableStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
