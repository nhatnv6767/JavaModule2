package ExampleDB.test;

import ExampleDB.dao.SachDAO;
import ExampleDB.model.Sach;

import java.util.ArrayList;

public class TestSachDAO {
    public static void main(String[] args) {
//        Sach sach1 = new Sach("LTJAVA", "Lap trinh Java", 50000, 2025);
//        Sach sach2 = new Sach("LTC", "Lap trinh C", 70000, 2030);
//
//        SachDAO.getInstance().insert(sach2);

        // TEST INSERT
//        for (int i = 0; i < 1000; i++) {
//            Sach sach = new Sach("LT" + i, "Lap trinh i: " + i, 50000, 2025);
//            SachDAO.getInstance().insert(sach);
//        }


        // TEST UPDATE
//        Sach sach2 = new Sach("LTC", "Lap trinh C", 123000, 2030);
//        SachDAO.getInstance().update(sach2);


        // TEST DELETE
//        for (int i = 0; i < 1000; i++) {
//            Sach sach = new Sach("LT" + i, "Lap trinh i: " + i, 50000, 2025);
//            SachDAO.getInstance().delete(sach);
//        }


        // SHOW ALL
        ArrayList<Sach> list = SachDAO.getInstance().selectAll();
        for (Sach sach : list) {
            System.out.println(sach.toString());
        }

        System.out.println("--------------------------------");
        Sach find = new Sach();
        find.setId("LTC");
        Sach sach2 = SachDAO.getInstance().selectById(find);
        System.out.println(sach2);

        System.out.println("--------------------------------");

        ArrayList<Sach> list2 = SachDAO.getInstance().selectByCondition("giaBan<70000");
        for (Sach sach : list2) {
            System.out.println(sach.toString());
        }
    }
}
