package ExampleDB.test;

import ExampleDB.dao.SachDAO;
import ExampleDB.model.Sach;

public class TestSachDAO {
    public static void main(String[] args) {
        Sach sach1 = new Sach("LTJAVA", "Lap trinh Java", 50000, 2025);
        Sach sach2 = new Sach("LTC", "Lap trinh C", 70000, 2030);

        SachDAO.getInstance().insert(sach2);

    }
}
