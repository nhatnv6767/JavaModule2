package ExampleDB.dao;

import ExampleDB.database.JDBCUtil;
import ExampleDB.model.Sach;
import ExampleDB.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO implements DAOInterface<User> {

    public static UserDAO getInstance() {
        return new UserDAO();
    }

    @Override
    public int insert(User user) {
        int check = 0;
        try {
            // B1: Tao ket noi den csdl
            Connection con = JDBCUtil.getConnection();

            // B2: Tao ra doi tuong statement
            Statement st = con.createStatement();

            // B3: Thuc thi cau lenh SQL
            String sql = "INSERT INTO user (username, password, hovaten) VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getHovaten() + "')";

            check = st.executeUpdate(sql);

            // B4: Xu ly ket qua
            System.out.println("Ban da thuc thi: " + sql);
            System.out.println("So dong thay doi: " + check);

            // B5: Ngat ket noi den csdl
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return check;
    }

    @Override
    public int update(User user) {
        int check = 0;
        try {
            // B1: Tao ket noi den csdl
            Connection con = JDBCUtil.getConnection();

            // B2: Tao ra doi tuong statement
            Statement st = con.createStatement();

            // B3: Thuc thi cau lenh SQL
            String sql = "UPDATE sach SET password = '" + user.getPassword() + "', hovaten = '" + user.getHovaten() + "' WHERE username = '" + user.getUsername() + "' ";

            check = st.executeUpdate(sql);

            // B4: Xu ly ket qua
            System.out.println("Ban da thuc thi: " + sql);
            System.out.println("So dong thay doi: " + check);

            // B5: Ngat ket noi den csdl
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return check;
    }

    @Override
    public int delete(User user) {
        int check = 0;
        try {
            // B1: Tao ket noi den csdl
            Connection con = JDBCUtil.getConnection();

            // B2: Tao ra doi tuong statement
            Statement st = con.createStatement();

            // B3: Thuc thi cau lenh SQL
            String sql = "DELETE from user WHERE username = '" + user.getUsername() + "' ";

            check = st.executeUpdate(sql);

            // B4: Xu ly ket qua
            System.out.println("Ban da thuc thi: " + sql);
            System.out.println("So dong thay doi: " + check);

            // B5: Ngat ket noi den csdl
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return check;
    }

    @Override
    public ArrayList<User> selectAll() {
        ArrayList<User> check = new ArrayList<>();
        ;
        try {
            // B1: Tao ket noi den csdl
            Connection con = JDBCUtil.getConnection();

            // B2: Tao ra doi tuong statement
            Statement st = con.createStatement();

            // B3: Thuc thi cau lenh SQL
            String sql = "SELECT * FROM user";

            ResultSet rs = st.executeQuery(sql);

            // B4: Xu ly ket qua
            // next => duyet tung dong (neu con du lieu)
            while (rs.next()) {
                User user = new User(rs.getString("username"), rs.getString("password"), rs.getString("hovaten"));
                check.add(user);
            }

            /*
            while (rs.next()) {
                String id = rs.getString("id");
                String tenSach = rs.getString("tenSach");
                float giaBan = rs.getFloat("giaBan");
                int namXuatBan = rs.getInt("namXuatBan");
                Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
                check.add(sach);
            }
            */

            // B5: Ngat ket noi den csdl
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return check;
    }

    @Override
    public User selectById(User user) {
        User result = null;
        try {
            // B1: Tao ket noi den csdl
            Connection con = JDBCUtil.getConnection();

            // B2: Tao ra doi tuong statement
            Statement st = con.createStatement();

            // B3: Thuc thi cau lenh SQL
            String sql = "SELECT * FROM user where username = '" + user.getUsername() + "'";

            ResultSet rs = st.executeQuery(sql);

            // B4: Xu ly ket qua
            // next => duyet tung dong (neu con du lieu)
            while (rs.next()) {
                result = new User(rs.getString("username"), rs.getString("password"), rs.getString("hovaten"));
            }


            /*
            while (rs.next()) {
                String id = rs.getString("id");
                String tenSach = rs.getString("tenSach");
                float giaBan = rs.getFloat("giaBan");
                int namXuatBan = rs.getInt("namXuatBan");
                Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
                check.add(sach);
            }
            */

            // B5: Ngat ket noi den csdl
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public ArrayList<User> selectByCondition(String condition) {
        ArrayList<User> check = new ArrayList<>();
        ;
        try {
            // B1: Tao ket noi den csdl
            Connection con = JDBCUtil.getConnection();

            // B2: Tao ra doi tuong statement
            Statement st = con.createStatement();

            // B3: Thuc thi cau lenh SQL
            String sql = "SELECT * FROM user where " + condition;

            ResultSet rs = st.executeQuery(sql);

            // B4: Xu ly ket qua
            // next => duyet tung dong (neu con du lieu)
            while (rs.next()) {
                User user = new User(rs.getString("username"), rs.getString("password"), rs.getString("hovaten"));
                check.add(user);
            }


            // B5: Ngat ket noi den csdl
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return check;
    }
}
