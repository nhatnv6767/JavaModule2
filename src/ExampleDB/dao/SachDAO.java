package ExampleDB.dao;

import ExampleDB.database.JDBCUtil;
import ExampleDB.model.Sach;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SachDAO implements DAOInterface<Sach> {

    public static SachDAO getInstance() {
        return new SachDAO();
    }

    @Override
    public int insert(Sach sach) {
        int check = 0;
        try {
            // B1: Tao ket noi den csdl
            Connection con = JDBCUtil.getConnection();

            // B2: Tao ra doi tuong statement
            Statement st = con.createStatement();

            // B3: Thuc thi cau lenh SQL
            String sql = "INSERT INTO sach (id, tenSach, giaBan, namXuatBan) VALUES ('" + sach.getId() + "', '" + sach.getTenSach() + "', " + sach.getGiaBan() + ", " + sach.getNamXuatBan() + ")";

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
    public int update(Sach sach) {
        int check = 0;
        try {
            // B1: Tao ket noi den csdl
            Connection con = JDBCUtil.getConnection();

            // B2: Tao ra doi tuong statement
            Statement st = con.createStatement();

            // B3: Thuc thi cau lenh SQL
            String sql = "UPDATE sach SET tenSach = '" + sach.getTenSach() + "', giaBan = " + sach.getGiaBan() + ", namXuatBan = '" + sach.getNamXuatBan() + "' WHERE id = '" + sach.getId() + "' ";

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
    public int delete(Sach sach) {
        int check = 0;
        try {
            // B1: Tao ket noi den csdl
            Connection con = JDBCUtil.getConnection();

            // B2: Tao ra doi tuong statement
            Statement st = con.createStatement();

            // B3: Thuc thi cau lenh SQL
            String sql = "DELETE from sach WHERE id = '" + sach.getId() + "' ";

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
    public ArrayList<Sach> selectAll() {
        return null;
    }

    @Override
    public Sach selectById(Sach sach) {
        return null;
    }

    @Override
    public ArrayList<Sach> selectByCondition(String condition) {
        return null;
    }
}
