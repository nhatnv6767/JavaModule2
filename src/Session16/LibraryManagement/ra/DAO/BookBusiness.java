package Session16.LibraryManagement.ra.DAO;

import Session16.LibraryManagement.ra.database.JDBCUtil;
import Session16.LibraryManagement.ra.entity.Book;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookBusiness implements DAOInterface<Book> {

    private Connection conn = null;
    private CallableStatement callSt = null;

    private void openConnection() {
        conn = new JDBCUtil().openConnection();
    }

    private void closeConnection() {
        new JDBCUtil().closeConnection(conn, callSt);
    }

    private Book mapBook(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setBookId(rs.getInt("BookId"));
        book.setBookName(rs.getString("BookName"));
        book.setTitle(rs.getString("Title"));
        book.setAuthor(rs.getString("Author"));
        book.setContent(rs.getString("Content"));
        book.setTotalPages(rs.getInt("TotalPages"));
        book.setPublisher(rs.getString("Publisher"));
        book.setPrice(rs.getDouble("Price"));
        book.setTypeId(rs.getInt("TypeId"));
        book.setDeleted(rs.getBoolean("IsDeleted"));
        return book;
    }

    @Override
    public void insert(Book book) {
        try {
            openConnection();
            callSt = conn.prepareCall("{call AddBook(?,?,?,?,?,?,?,?)}");
            callSt.setString(1, book.getBookName());
            callSt.setString(2, book.getTitle());
            callSt.setString(3, book.getAuthor());
            callSt.setString(4, book.getContent());
            callSt.setInt(5, book.getTotalPages());
            callSt.setString(6, book.getPublisher());
            callSt.setDouble(7, book.getPrice());
            callSt.setInt(8, book.getTypeId());
            callSt.executeUpdate();
            System.out.println("Thêm mới thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    @Override
    public void update(Book book) {
        try {
            openConnection();
            callSt = conn.prepareCall("{call UpdateBook(?,?,?,?,?,?,?,?,?)}");
            callSt.setInt(1, book.getBookId());
            callSt.setString(2, book.getBookName());
            callSt.setString(3, book.getTitle());
            callSt.setString(4, book.getAuthor());
            callSt.setString(5, book.getContent());
            callSt.setInt(6, book.getTotalPages());
            callSt.setString(7, book.getPublisher());
            callSt.setDouble(8, book.getPrice());
            callSt.setInt(9, book.getTypeId());
            callSt.executeUpdate();
            System.out.println("Cập nhật thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    @Override
    public void delete(Book book) {
        try {
            openConnection();
            callSt = conn.prepareCall("{call DeleteBook(?)}");
            callSt.setInt(1, book.getBookId());
            callSt.executeUpdate();
            System.out.println("Xóa thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    @Override
    public Book get(int id) {
        try {
            openConnection();
            callSt = conn.prepareCall("{call GetBookById(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                return mapBook(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    @Override
    public Book get(String name) {
        try {
            openConnection();
            callSt = conn.prepareCall("{call GetBookByName(?)}");
            callSt.setString(1, name);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                return mapBook(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    @Override
    public Book get(Book book) {
        return null;
    }

    @Override
    public Book[] getAll() {
        List<Book> books = new ArrayList<>();
        try {
            openConnection();
            callSt = conn.prepareCall("{call GetAllBook()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                books.add(mapBook(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return books.toArray(new Book[0]);

    }

    public List<Book> sortBooksByPrice(String sortOrder) {
        List<Book> books = new ArrayList<>();
        try {
            openConnection();
            callSt = conn.prepareCall("{call SortBooksByPrice(?)}");
            callSt.setString(1, sortOrder);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                books.add(mapBook(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return books;
    }

    public List<Book> searchBooks(String keyword) {
        List<Book> books = new ArrayList<>();
        try {
            openConnection();
            callSt = conn.prepareCall("{call SearchBooks(?)}");
            callSt.setString(1, keyword);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                books.add(mapBook(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return books;
    }

    public void getBookCountByPages() {
        try {
            openConnection();
            callSt = conn.prepareCall("{call GetBookCountByPages()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                System.out.println("Số lượng sách có số trang " + rs.getInt("TotalPages") + " là " + rs.getInt("SoLuongSach"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}
