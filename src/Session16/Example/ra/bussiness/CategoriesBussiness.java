package Session16.Example.ra.bussiness;

import Session16.Example.ra.entity.Categories;
import Session16.Example.ra.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
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

    // Them moi danh muc
    public static boolean save(Categories catalog) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_categories(?, ?, ?)}");
            // 1. set gia tri cho cac tham so vao
            callSt.setString(1, catalog.getCatalogName());
            callSt.setString(2, catalog.getDescription());
            callSt.setBoolean(3, catalog.isStatus());
            // 2. dang ky kieu du lieu cho cac tham so ra

            // 3. Thuc hien goi procedure
            callSt.executeUpdate();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }


    public static Categories findById(int catalogId) {
        Connection conn = null;
        CallableStatement callSt = null;
        Categories catalog = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_categories_by_id(?)}");
            ResultSet rs = callSt.executeQuery();
            catalog = new Categories();
            while (rs.next()) {
                catalog.setCatalogId(rs.getInt("category_id"));
                catalog.setCatalogName(rs.getString("category_name"));
                catalog.setDescription(rs.getString("catalog_description"));
                catalog.setStatus(rs.getBoolean("catalog_status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return catalog;
    }

    public static boolean update(Categories catalog) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_categories(?, ?, ?, ?)}");
            // 1. set gia tri cho cac tham so vao
            callSt.setInt(1, catalog.getCatalogId());
            callSt.setString(2, catalog.getCatalogName());
            callSt.setString(3, catalog.getDescription());
            callSt.setBoolean(4, catalog.isStatus());
            // 2. dang ky kieu du lieu cho cac tham so ra

            // 3. Thuc hien goi procedure
            callSt.executeUpdate();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }


    public static boolean delete(int catalogId) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_categories(?)}");
            // 1. set gia tri cho cac tham so vao
            callSt.setInt(1, catalogId);
            // 2. dang ky kieu du lieu cho cac tham so ra

            // 3. Thuc hien goi procedure
            callSt.executeUpdate();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    public static int statisticCategories(boolean status) {
        Connection conn = null;
        CallableStatement callSt = null;
        int cntCategories = 0;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call statictic_categories(?, ?)}");
            // 1. set gia tri cho cac tham so vao
            callSt.setBoolean(1, status);
            // 2. dang ky kieu du lieu cho cac tham so ra
            callSt.registerOutParameter(2, Types.INTEGER);

            // 3. Thuc hien goi procedure
            // vi co tham so tra ra nen se dung execute
            callSt.execute();
            // 4. lay gia tri cac tham so tra ra
            cntCategories = callSt.getInt(2);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return cntCategories;
    }
}
