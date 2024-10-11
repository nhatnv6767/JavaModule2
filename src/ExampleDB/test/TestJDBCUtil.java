package ExampleDB.test;

import ExampleDB.database.JDBCUtil;

import java.sql.Connection;

public class TestJDBCUtil {
    public static void main(String[] args) {
        Connection connection = JDBCUtil.getConnection();
        System.out.println(connection);

        JDBCUtil.closeConnection(connection);
        System.out.println(connection);
    }
}
