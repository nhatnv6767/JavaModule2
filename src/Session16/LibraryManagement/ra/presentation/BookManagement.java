package Session16.LibraryManagement.ra.presentation;

import Session16.LibraryManagement.ra.DAO.BookBusiness;
import Session16.LibraryManagement.ra.DAO.BookTypeBusiness;
import Session16.LibraryManagement.ra.entity.Book;
import Session16.LibraryManagement.ra.entity.BookType;

import java.util.List;
import java.util.Scanner;

public class BookManagement {
    private static final BookTypeBusiness bookTypeBusiness = new BookTypeBusiness();
    private static final BookBusiness bookBusiness = new BookBusiness();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("******************BOOK-MANAGEMENT******************\n" +
                    "1. Quản lý loại sách \n" +
                    "2. Quản lý sách \n" +
                    "0. Thoát  \n");
            System.out.printf("Nhập lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    bookTypeMenu(scanner);
                    break;
                case 2:
                    bookMenu(scanner);
                    break;
                case 0:
                    System.err.println("Thoát chương trình");
                    break;
                default:
                    System.err.println("Nhập sai, vui lòng nhập lại");
                    break;
            }
        } while (choice != 0);
    }

    private static void bookTypeMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("**********************BOOKTYPE-MENU******************** \n" +
                    "1. Danh sách loại sách \n" +
                    "2. Tạo mới loại sách \n" +
                    "3. Cập nhật thông tin loại sách \n" +
                    "4. Xóa loại sách \n" +
                    "5. Thống kê số lượng sách theo mã loại sách \n" +
                    "0. Thoát  \n");
            System.out.printf("Nhập lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());

        } while (choice != 0);
    }

    private static void bookMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("***********************BOOK-MENU*********************** \n" +
                    "1. Danh sách sách \n" +
                    "2. Tạo mới sách \n" +
                    "3. Cập nhật thông tin sách \n" +
                    "4. Xóa sách \n" +
                    "5. Hiển thị danh sách các cuốn sách theo giá giảm dần \n" +
                    "6. Tìm kiếm sách theo tên hoặc nội dung \n" +
                    "7. Thống kê số lượng sách theo nhóm  \n" +
                    "8. Thoát \n");
            System.out.printf("Nhập lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());

        } while (choice != 0);
    }

    // BookType
    private static void addBookType(Scanner scanner) {
        BookType bookType = new BookType();
        bookType.inputData(scanner);
        bookTypeBusiness.insert(bookType);
    }

    private static void updateBookType(Scanner scanner) {
        System.out.print("Nhập mã loại sách cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        BookType existingBookType = bookTypeBusiness.get(id);
        if (existingBookType == null) {
            System.err.println("Không tìm thấy loại sách");
            return;
        }
        existingBookType.inputData(scanner);
        bookTypeBusiness.update(existingBookType);
    }

    private static void deleteBookType(Scanner scanner) {
        System.out.print("Nhập mã loại sách cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        BookType existingBookType = bookTypeBusiness.get(id);
        if (existingBookType == null) {
            System.err.println("Không tìm thấy loại sách");
            return;
        }
        bookTypeBusiness.delete(existingBookType);
    }

    private static void displayAllBookType() {
        BookType[] bookTypes = bookTypeBusiness.getAll();
        for (BookType bookType : bookTypes) {
            bookType.displayData();
            System.out.println("----------------------");
        }
    }

    // Book

    private static void addBook(Scanner scanner) {
        Book book = new Book();
        book.inputData(scanner);
        bookBusiness.insert(book);
    }

    private static void updateBook(Scanner scanner) {
        System.out.print("Nhập mã sách cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        Book existingBook = bookBusiness.get(id);
        if (existingBook == null) {
            System.err.println("Không tìm thấy sách");
            return;
        }
        existingBook.inputData(scanner);
        bookBusiness.update(existingBook);
    }

    private static void deleteBook(Scanner scanner) {
        System.out.print("Nhập mã sách cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Book existingBook = bookBusiness.get(id);
        if (existingBook == null) {
            System.err.println("Không tìm thấy sách");
            return;
        }
        bookBusiness.delete(existingBook);
    }

    private static void displayAllBook() {
        Book[] books = bookBusiness.getAll();
        for (Book book : books) {
            book.displayData();
            System.out.println("----------------------");
        }
    }

    private static void sortBooksByPrice(Scanner scanner) {
        System.out.print("Nhập thứ tự sắp xếp (ASC hoặc DESC): ");
        String order = scanner.nextLine();
        List<Book> books = bookBusiness.sortBooksByPrice(order);
        for (Book book : books) {
            book.displayData();
            System.out.println("----------------------");
        }
    }

    private static void searchBook(Scanner scanner) {
        System.out.print("Nhập tên hoặc nội dung sách cần tìm: ");
        String keyword = scanner.nextLine();
        List<Book> books = bookBusiness.searchBooks(keyword);
        for (Book book : books) {
            book.displayData();
            System.out.println("----------------------");
        }
    }
}
