package ExampleDBHibernate.dao;

import ExampleDB.database.JDBCUtil;
import ExampleDB.model.Sach;

import java.sql.Connection;
import java.sql.ResultSet;
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
        ArrayList<Sach> check = new ArrayList<>();
        ;
        try {
            // B1: Tao ket noi den csdl
            Connection con = JDBCUtil.getConnection();

            // B2: Tao ra doi tuong statement
            Statement st = con.createStatement();

            // B3: Thuc thi cau lenh SQL
            String sql = "SELECT * FROM sach";

            ResultSet rs = st.executeQuery(sql);

            // B4: Xu ly ket qua
            // next => duyet tung dong (neu con du lieu)
            while (rs.next()) {
                Sach sach = new Sach(rs.getString("id"), rs.getString("tenSach"), rs.getFloat("giaBan"), rs.getInt("namXuatBan"));
                check.add(sach);
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
    public Sach selectById(Sach sach) {
        Sach result = null;
        try {
            // B1: Tao ket noi den csdl
            Connection con = JDBCUtil.getConnection();

            // B2: Tao ra doi tuong statement
            Statement st = con.createStatement();

            // B3: Thuc thi cau lenh SQL
            String sql = "SELECT * FROM sach where id = '" + sach.getId() + "'";

            ResultSet rs = st.executeQuery(sql);

            // B4: Xu ly ket qua
            // next => duyet tung dong (neu con du lieu)
            while (rs.next()) {
                result = new Sach(rs.getString("id"), rs.getString("tenSach"), rs.getFloat("giaBan"), rs.getInt("namXuatBan"));
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
    public ArrayList<Sach> selectByCondition(String condition) {
        ArrayList<Sach> check = new ArrayList<>();
        ;
        try {
            // B1: Tao ket noi den csdl
            Connection con = JDBCUtil.getConnection();

            // B2: Tao ra doi tuong statement
            Statement st = con.createStatement();

            // B3: Thuc thi cau lenh SQL
            String sql = "SELECT * FROM sach where " + condition;

            ResultSet rs = st.executeQuery(sql);

            // B4: Xu ly ket qua
            // next => duyet tung dong (neu con du lieu)
            while (rs.next()) {
                Sach sach = new Sach(rs.getString("id"), rs.getString("tenSach"), rs.getFloat("giaBan"), rs.getInt("namXuatBan"));
                check.add(sach);
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
