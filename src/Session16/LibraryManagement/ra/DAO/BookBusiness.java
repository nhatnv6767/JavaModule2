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
        if (book == null || !isValidBook(book)) {
            System.err.println("Dữ liệu không hợp lệ");
            return;
        }
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
        if (book == null || !isValidBook(book)) {
            System.err.println("Dữ liệu không hợp lệ");
            return;
        }
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
        if (book == null || book.getBookId() <= 0) {
            System.err.println("Id không hợp lệ");
            return;
        }
        try {
            openConnection();

            if (get(book.getBookId()) == null) {
                System.out.println("Không tìm thấy sách");
                return;
            }

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
        if (id <= 0) {
            System.err.println("Id không hợp lệ");
            return null;
        }
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
        if (name == null || name.trim().isEmpty()) {
            System.err.println("Vui lòng nhập tên sách");
            return null;
        }
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
        if (sortOrder == null || (!sortOrder.equalsIgnoreCase("ASC") && !sortOrder.equalsIgnoreCase("DESC"))) {
            System.err.println("Vui lòng nhập ASC hoặc DESC");
            return new ArrayList<>();
        }
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
        if (keyword == null || keyword.trim().isEmpty()) {
            System.err.println("Vui lòng nhập từ khóa tìm kiếm");
            return new ArrayList<>();
        }
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

    private boolean isValidBook(Book book) {
        return book.getBookName() != null && !book.getBookName().trim().isEmpty() &&
                book.getTitle() != null && !book.getTitle().trim().isEmpty() &&
                book.getAuthor() != null && !book.getAuthor().trim().isEmpty() &&
                book.getContent() != null && !book.getContent().trim().isEmpty() &&
                book.getTotalPages() > 0 &&
                book.getPublisher() != null && !book.getPublisher().trim().isEmpty() &&
                book.getPrice() > 0 &&
                book.getTypeId() > 0;
    }
}
