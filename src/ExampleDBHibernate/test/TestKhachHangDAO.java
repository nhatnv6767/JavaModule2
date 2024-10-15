package ExampleDBHibernate.test;

import ExampleDB.dao.KhachHangDAO;
import ExampleDB.model.KhachHang;

import java.util.ArrayList;

public class TestKhachHangDAO {
    public static void main(String[] args) {
        ArrayList<KhachHang> list = KhachHangDAO.getInstance().selectAll();
        for (KhachHang kh : list) {
            System.out.println(kh.toString());
        }
    }
}
