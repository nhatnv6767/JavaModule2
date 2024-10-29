package Session16.Example.ra.util;

import java.sql.Connection;
import java.sql.DriverManager;

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
        // 1. Set Driver cho DriverManager
        // 2. Khoi tao doi tuong Connection tu DriverManager
        // 3. Tra ve doi tuong Connection

        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = openConnection();
        if (conn != null) {
            System.out.println("Ket noi thanh cong");
        } else {
            System.out.println("Ket noi fail");
        }
    }
}
