package ExampleDB.dao;

import ExampleDB.database.JDBCUtil;
import ExampleDB.model.KhachHang;
import ExampleDB.model.Sach;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class KhachHangDAO implements DAOInterface<KhachHang> {

    public static KhachHangDAO getInstance() {
        return new KhachHangDAO();
    }


    @Override
    public int insert(KhachHang khachHang) {
        return 0;
    }

    @Override
    public int update(KhachHang khachHang) {
        return 0;
    }

    @Override
    public int delete(KhachHang khachHang) {
        return 0;
    }

    @Override
    public ArrayList<KhachHang> selectAll() {
        ArrayList<KhachHang> check = new ArrayList<>();
        ;
        try {
            // B1: Tao ket noi den csdl
            Connection con = JDBCUtil.getConnection();

            // B2: Tao ra doi tuong statement
            Statement st = con.createStatement();

            // B3: Thuc thi cau lenh SQL
            String sql = "SELECT * FROM khachHang";

            ResultSet rs = st.executeQuery(sql);

            // B4: Xu ly ket qua
            // next => duyet tung dong (neu con du lieu)
            while (rs.next()) {
//                Date ngaySinh = rs.getDate("ngaySinh");
                KhachHang kh = new KhachHang(rs.getInt("id"), rs.getString("hoVaTen"), rs.getDate("ngaySinh"), rs.getString("diaChi"));
                check.add(kh);
            }

            // B5: Ngat ket noi den csdl
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return check;
    }

    @Override
    public KhachHang selectById(KhachHang khachHang) {
        return null;
    }

    @Override
    public ArrayList<KhachHang> selectByCondition(String condition) {
        return null;
    }
}
