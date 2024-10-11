package ExampleDB.test;

import ExampleDB.database.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCUtil {
    public static void main(String[] args) {
        try {
            // B1: Tao ket noi
            Connection connection = JDBCUtil.getConnection();

            // B2: tao ra doi tuong statement
            Statement st = connection.createStatement();

            // B3: thuc thi cau lenh sql
            String sql = "INSERT INTO Persons( last_name, first_name, gender, dob, income) VALUES (\"Nathun\", \"Tr\",\"M\", \"1999-05-10\", 10000000),\n" +
                    "                                                                        (\"Lung\", \"Tr\",\"M\", \"1996-05-10\", 11000000),\n" +
                    "                                                                        (\"Linh\", \"Tr\",\"M\", \"1998-05-10\", 12000000),\n" +
                    "                                                                        (\"Mathan\", \"Tr\",\"M\", \"1991-05-10\", 15000000),\n" +
                    "                                                                        (\"C4ris\", \"Tr\",\"M\", \"2005-05-10\", 17000000);";

            int check = st.executeUpdate(sql);

            // B4: xu ly ket qua
            System.out.println("So dong thay doi: " + check);
            if (check > 0) {
                System.out.println("Them du lieu thanh cong");
            } else {
                System.out.println("Them du lieu that bai");
            }


            JDBCUtil.closeConnection(connection);
//        JDBCUtil.printInfo(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
