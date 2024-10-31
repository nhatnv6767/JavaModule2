package Session16.LibraryManagement.ra.DAO;

import Session16.LibraryManagement.ra.database.JDBCUtil;
import Session16.LibraryManagement.ra.entity.BookType;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookTypeBusiness implements DAOInterface<BookType> {

    private Connection conn = null;
    private CallableStatement callSt = null;

    private void openConnection() {
        conn = new JDBCUtil().openConnection();
    }

    private void closeConnection() {
        new JDBCUtil().closeConnection(conn, callSt);
    }

    private BookType mapBookType(ResultSet rs) throws SQLException {
        BookType bookType = new BookType();
        bookType.setTypeId(rs.getInt("TypeId"));
        bookType.setTypeName(rs.getString("TypeName"));
        bookType.setDescription(rs.getString("Description"));
        bookType.setDeleted(rs.getBoolean("IsDeleted"));
        return bookType;
    }

    @Override
    public void insert(BookType bookType) {
        try {
            openConnection();
            callSt = conn.prepareCall("{call AddBookType(?,?)}");
            callSt.setString(1, bookType.getTypeName());
            callSt.setString(2, bookType.getDescription());
            callSt.executeUpdate();
            System.out.println("Thêm mới thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    @Override
    public void update(BookType bookType) {
        try {
            openConnection();
            callSt = conn.prepareCall("{call UpdateBookType(?,?,?)}");
            callSt.setInt(1, bookType.getTypeId());
            callSt.setString(2, bookType.getTypeName());
            callSt.setString(3, bookType.getDescription());
            callSt.executeUpdate();
            System.out.println("Cập nhật thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    @Override
    public void delete(BookType bookType) {
        try {
            openConnection();
            callSt = conn.prepareCall("{call DeleteBookType(?)}");
            callSt.setInt(1, bookType.getTypeId());
            callSt.executeUpdate();
            System.out.println("Xóa thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    @Override
    public BookType get(int id) {
        try {
            openConnection();
            callSt = conn.prepareCall("{call GetBookTypeById(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                return mapBookType(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    @Override
    public BookType get(String name) {
        return null;
    }

    @Override
    public BookType get(BookType bookType) {
        return null;
    }

    @Override
    public BookType[] getAll() {
        List<BookType> listBookTypes = new ArrayList<>();
        try {
            openConnection();
            callSt = conn.prepareCall("{call GetAllBookType()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                listBookTypes.add(mapBookType(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return listBookTypes.toArray(new BookType[0]);
    }

    public void getBookCountByTypes() {
        try {
            openConnection();
            callSt = conn.prepareCall("{call GetBookCountByTypes()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                System.out.println("Loại sách: " + rs.getString("TypeName") + " - Số lượng: " + rs.getInt("SoLuongSach"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}
