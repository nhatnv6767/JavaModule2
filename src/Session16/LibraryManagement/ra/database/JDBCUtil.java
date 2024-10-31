package Session16.LibraryManagement.ra.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {

    private static final String DB_URL = "jdbc:mysql://192.168.1.113:3306/library_management";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "123456";

    public Connection openConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(Connection conn, CallableStatement callSt) {
        if (callSt != null) {
            try {
                callSt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
