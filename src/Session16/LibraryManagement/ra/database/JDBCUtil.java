package Session16.LibraryManagement.ra.database;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

    //    private static final String DB_URL = "jdbc:mysql://192.168.1.113:3306/library_management";
//    private static final String DB_USER = "root";
//    private static final String DB_PASSWORD = "123456";
    private static final String DB_PROPERTIES_FILE = "src/database.properties";

    public Connection openConnection() {
//        Connection conn = null;
        try (FileInputStream input = new FileInputStream(DB_PROPERTIES_FILE)) {
            Properties prop = new Properties();
            prop.load(input);
            String dbUrl = prop.getProperty("db.url");
            String dbUser = prop.getProperty("db.user");
            String dbPassword = prop.getProperty("db.password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void closeConnection(Connection conn, CallableStatement callSt) {
        try {
            if (callSt != null) {
                callSt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
