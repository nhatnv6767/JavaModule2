package Session16.LibraryManagement.ra.presentation;

import Session16.LibraryManagement.ra.DAO.BookBusiness;
import Session16.LibraryManagement.ra.DAO.BookTypeBusiness;
import Session16.LibraryManagement.ra.Validation.BookValidator;
import Session16.LibraryManagement.ra.entity.Book;
import Session16.LibraryManagement.ra.entity.BookType;

import java.util.List;
import java.util.Scanner;

public class BookManagement {
    private static BookTypeBusiness bookTypeBusiness = new BookTypeBusiness();
    private static final BookBusiness bookBusiness = new BookBusiness();
    private static final BookValidator bookValidator = new BookValidator(bookTypeBusiness);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("******************BOOK-MANAGEMENT******************\n" +
                    "1. Quản lý loại sách \n" +
                    "2. Quản lý sách \n" +
                    "0. Thoát  \n");
            System.out.printf("Nhập lựa chọn: ");
            choice = getIntInput(scanner);
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
                    "0. Quay lại trang chính  \n");
            System.out.printf("Nhập lựa chọn: ");
            choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    displayAllBookType();
                    break;
                case 2:
                    addBookType(scanner);
                    break;
                case 3:
                    updateBookType(scanner);
                    break;
                case 4:
                    deleteBookType(scanner);
                    break;
                case 5:
                    bookTypeBusiness.getBookCountByTypes();
                    break;
                case 0:
                    break;
                default:
                    System.err.println("Nhập sai, vui lòng nhập lại");
            }
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
                    "0. Quay lại trang chính \n");
            System.out.printf("Nhập lựa chọn: ");
            choice = getIntInput(scanner);
            switch (choice) {
                case 1:
                    displayAllBook();
                    break;
                case 2:
                    addBook(scanner);
                    break;
                case 3:
                    updateBook(scanner);
                    break;
                case 4:
                    deleteBook(scanner);
                    break;
                case 5:
//                    cho nay chi cho sap xep theo giam dan
                    sortBooksByPrice(scanner);
                    break;
                case 6:
                    searchBook(scanner);
                    break;
                case 7:
                    bookBusiness.getBookCountByPages();
                    break;
                case 0:
                    break;
                default:
                    System.err.println("Nhập sai, vui lòng nhập lại");
            }

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
        int id = getIntInput(scanner);
        BookType existingBookType = bookTypeBusiness.get(id);
        if (existingBookType == null) {
            System.err.println("Không tìm thấy loại sách");
            return;
        }

        System.out.println("Thông tin loại sách cần cập nhật: ");
        existingBookType.displayData();

        System.out.println("Nhập thông tin mới");
        System.out.println("Nhập tên loại sách mới (bỏ qua nếu không muốn thay đổi): ");
        String newTypeName = scanner.nextLine().trim();
        if (!newTypeName.isEmpty()) {
            existingBookType.setTypeName(newTypeName);
        }

        System.out.println("Nhập mô tả mới (bỏ qua nếu không muốn thay đổi): ");
        String newDescription = scanner.nextLine().trim();
        if (!newDescription.isEmpty()) {
            existingBookType.setDescription(newDescription);
        }

//        existingBookType.inputData(scanner);
        bookTypeBusiness.update(existingBookType);
    }

    private static void deleteBookType(Scanner scanner) {
        System.out.print("Nhập mã loại sách cần xóa: ");
        int id = getIntInput(scanner);
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
        book.inputData(scanner, bookValidator);
        bookBusiness.insert(book);
    }

    private static void updateBook(Scanner scanner) {
        System.out.print("Nhập mã sách cần cập nhật: ");
        int id = getIntInput(scanner);
        Book existingBook = bookBusiness.get(id);
        if (existingBook == null) {
            System.err.println("Không tìm thấy sách");
            return;
        }

        System.out.println("Thông tin sách cần cập nhật: ");
        existingBook.displayData();

        int choice;
        do {
            System.out.println("Chọn thông tin cần cập nhật:");
            System.out.println("1. Tên sách");
            System.out.println("2. Tiêu đề");
            System.out.println("3. Tác giả");
            System.out.println("4. Nội dung");
            System.out.println("5. Tổng số trang");
            System.out.println("6. Nhà xuất bản");
            System.out.println("7. Giá");
            System.out.println("8. Mã loại sách");
            System.out.println("0. Hoàn tất cập nhật");
            System.out.print("Nhập lựa chọn: ");

            choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên sách mới: ");
                    String newBookName = scanner.nextLine().trim();
                    if (!newBookName.isEmpty()) {
                        existingBook.setBookName(newBookName);
                    }
                    break;
                case 2:
                    System.out.print("Nhập tiêu đề mới: ");
                    String newTitle = scanner.nextLine().trim();
                    if (!newTitle.isEmpty()) {
                        existingBook.setTitle(newTitle);
                    }
                    break;
                case 3:
                    System.out.print("Nhập tác giả mới: ");
                    String newAuthor = scanner.nextLine().trim();
                    if (!newAuthor.isEmpty()) {
                        existingBook.setAuthor(newAuthor);
                    }
                    break;
                case 4:
                    System.out.print("Nhập nội dung mới: ");
                    String newContent = scanner.nextLine().trim();
                    if (!newContent.isEmpty()) {
                        existingBook.setContent(newContent);
                    }
                    break;
                case 5:
                    int newTotalPages;
                    do {
                        System.out.print("Nhập tổng số trang mới: ");
                        newTotalPages = getIntInput(scanner);
                        if (newTotalPages <= 0) {
                            System.err.println("Số trang phải là số nguyên lớn hơn 0");
                        }
                    } while (newTotalPages <= 0);
                    existingBook.setTotalPages(newTotalPages);
                    break;
                case 6:
                    System.out.print("Nhập nhà xuất bản mới: ");
                    String newPublisher = scanner.nextLine().trim();
                    if (!newPublisher.isEmpty()) {
                        existingBook.setPublisher(newPublisher);
                    }
                    break;
                case 7:
                    double newPrice;
                    do {
                        System.out.print("Nhập giá mới: ");
                        newPrice = Double.parseDouble(scanner.nextLine());
                        if (newPrice <= 0) {
                            System.err.println("Giá phải là số dương lớn hơn 0");
                        }
                    } while (newPrice <= 0);
                    existingBook.setPrice(newPrice);
                    break;
                case 8:
                    int newTypeId;
                    do {
                        System.out.print("Nhập mã loại sách mới: ");
                        newTypeId = getIntInput(scanner);
                        if (bookTypeBusiness.get(newTypeId) == null) {
                            System.err.println("Mã loại sách không tồn tại.");
                        }
                    } while (bookTypeBusiness.get(newTypeId) == null);
                    existingBook.setTypeId(newTypeId);
                    break;
                case 0:
                    System.out.println("Hoàn tất cập nhật.");
                    break;
                default:
                    System.err.println("Nhập sai, vui lòng nhập lại");
            }
        } while (choice != 0);


        bookBusiness.update(existingBook);
    }

    private static void deleteBook(Scanner scanner) {
        System.out.print("Nhập mã sách cần xóa: ");
        int id = getIntInput(scanner);
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
        String order;
        while (true) {
            System.out.print("Nhập thứ tự sắp xếp (ASC hoặc DESC): ");
            order = scanner.nextLine();
            if (order.equalsIgnoreCase("ASC") || order.equalsIgnoreCase("DESC")) {
                break;
            }
            System.err.println("Vui lòng nhập ASC hoặc DESC");
        }
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

    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số nguyên");
            }
        }
    }
}
