package Session16.Example.ra.bussiness;

import Session16.Example.ra.entity.Categories;
import Session16.Example.ra.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriesBussiness {
    // Danh sach danh muc
    public static List<Categories> findAll() {
        // 1. Tao doi tuong Connection
        // 2. Tao doi tuong CallableStatement tu doi tuong Connection
        // 3. Goi va thuc thi procedure
        // 4. Hung du lieu va xu ly du lieu
        // 5. Dong ket noi

        Connection conn = null;
        CallableStatement callSt = null;
        List<Categories> listCategories = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_categories()}");
            ResultSet rs = callSt.executeQuery();
            listCategories = new ArrayList<>();
            while (rs.next()) {
                Categories catalog = new Categories();
                catalog.setCatalogId(rs.getInt("category_id"));
                catalog.setCatalogName(rs.getString("category_name"));
                catalog.setDescription(rs.getString("catalog_description"));
                catalog.setStatus(rs.getBoolean("catalog_status"));
                listCategories.add(catalog);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listCategories;
    }
}
