package Session16.CataProdManagement.ra.bussiness;

import Session16.CataProdManagement.ra.util.ConnectionDB;
import Session16.CataProdManagement.ra.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductBussiness {

    private static Connection openConnection() throws SQLException {
        return ConnectionDB.openConnection();
    }

    private static void closeConnection(Connection conn, CallableStatement callSt) {
        ConnectionDB.closeConnection(conn, callSt);
    }

    private static Product mapProduct(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setProductId(rs.getString("product_id"));
        product.setProductName(rs.getString("product_name"));
        product.setProductPrice(rs.getFloat("product_price"));
        product.setProductTitle(rs.getString("product_title"));
        product.setProductDescription(rs.getString("product_description"));
        product.setCatalogId(rs.getInt("catalog_id"));
        product.setProductStatus(rs.getBoolean("product_status"));
        return product;
    }

    public static List<Product> findAll() {
        List<Product> listProduct = null;
        try (Connection conn = openConnection();
             CallableStatement callSt = conn.prepareCall("{call find_all_product()}")) {
            ResultSet rs = callSt.executeQuery();
            listProduct = new ArrayList<>();
            while (rs.next()) {
                listProduct.add(mapProduct(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProduct;
    }

    public static boolean save(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_product(?, ?, ?, ?, ?, ?, ?)}");
            callSt.setString(1, product.getProductId());
            callSt.setString(2, product.getProductName());
            callSt.setFloat(3, product.getProductPrice());
            callSt.setString(4, product.getProductTitle());
            callSt.setString(5, product.getProductDescription());
            callSt.setInt(6, product.getCatalogId());
            callSt.setBoolean(7, product.isProductStatus());
            callSt.executeUpdate();
            result = true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    public static Product findById(String productId) {
        Connection conn = null;
        CallableStatement callSt = null;
        Product product = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_product_by_id(?)}");
            callSt.setString(1, productId);
            ResultSet rs = callSt.executeQuery();
            product = new Product();
            while (rs.next()) {
                product.setProductId(rs.getString("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getFloat("product_price"));
                product.setProductTitle(rs.getString("product_title"));
                product.setProductDescription(rs.getString("product_description"));
                product.setCatalogId(rs.getInt("catalog_id"));
                product.setProductStatus(rs.getBoolean("product_status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return product;
    }

    public static boolean update(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_product(?, ?, ?, ?, ?, ?, ?)}");
            callSt.setString(1, product.getProductId());
            callSt.setString(2, product.getProductName());
            callSt.setFloat(3, product.getProductPrice());
            callSt.setString(4, product.getProductTitle());
            callSt.setString(5, product.getProductDescription());
            callSt.setInt(6, product.getCatalogId());
            callSt.setBoolean(7, product.isProductStatus());
            callSt.executeUpdate();
            result = true;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    public static boolean delete(String productId) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_product(?)}");
            callSt.setString(1, productId);
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    public static List<Product> searchProduct(String searchTerm) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> findProduct = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call search_product(?)}");
            callSt.setString(1, searchTerm);
            ResultSet rs = callSt.executeQuery();
            findProduct = new ArrayList<>();

            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getFloat("product_price"));
                product.setProductTitle(rs.getString("product_title"));
                product.setProductDescription(rs.getString("product_description"));
                product.setCatalogId(rs.getInt("catalog_id"));
                product.setProductStatus(rs.getBoolean("product_status"));
                findProduct.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return findProduct;

    }

    public static int statisticProductByPrice(float priceFrom, float priceTo) {
        Connection conn = null;
        CallableStatement callSt = null;
        int cntProduct = 0;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call statistic_product_by_price(?, ?, ?)}");
            callSt.setFloat(1, priceFrom);
            callSt.setFloat(2, priceTo);
            callSt.registerOutParameter(3, Types.INTEGER);
            callSt.execute();
            cntProduct = callSt.getInt(3);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return cntProduct;
    }

    public static List<Product> sortProductByPrice() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> listProduct = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call sort_product_by_price()}");
            ResultSet rs = callSt.executeQuery();
            listProduct = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getFloat("product_price"));
                product.setProductTitle(rs.getString("product_title"));
                product.setProductDescription(rs.getString("product_description"));
                product.setCatalogId(rs.getInt("catalog_id"));
                product.setProductStatus(rs.getBoolean("product_status"));
                listProduct.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listProduct;
    }

    public static int statisticProductByCategory(int categoryId) {
        Connection conn = null;
        CallableStatement callSt = null;
        int cntProduct = 0;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call statistic_product_by_category(?, ?)}");
            callSt.setInt(1, categoryId);
            callSt.registerOutParameter(2, Types.INTEGER);
            callSt.execute();
            cntProduct = callSt.getInt(2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return cntProduct;
    }
}
