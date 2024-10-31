package Session16.LibraryManagement.ra.entity;

import java.util.Scanner;

public class Book implements IBookManagement {
    private int bookId;
    private String bookName;
    private String title;
    private String author;
    private String content;
    private int totalPages;
    private String publisher;
    private double price;
    private int typeId;
    private boolean isDeleted;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, String author, String content, int totalPages, String publisher, double price, int typeId, boolean isDeleted) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.author = author;
        this.content = content;
        this.totalPages = totalPages;
        this.publisher = publisher;
        this.price = price;
        this.typeId = typeId;
        this.isDeleted = isDeleted;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên sách: ");
        this.bookName = scanner.nextLine();
        System.out.print("Nhập tiêu đề: ");
        this.title = scanner.nextLine();
        System.out.print("Nhập tác giả: ");
        this.author = scanner.nextLine();
        System.out.print("Nhập nội dung: ");
        this.content = scanner.nextLine();
        System.out.print("Nhập số trang: ");
        this.totalPages = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập nhà xuất bản: ");
        this.publisher = scanner.nextLine();
        System.out.print("Nhập giá: ");
        this.price = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập mã loại sách: ");
        this.typeId = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("Mã sách: %d\n", this.bookId);
        System.out.printf("Tên sách: %s\n", this.bookName);
        System.out.printf("Tiêu đề: %s\n", this.title);
        System.out.printf("Tác giả: %s\n", this.author);
        System.out.printf("Nội dung: %s\n", this.content);
        System.out.printf("Số trang: %d\n", this.totalPages);
        System.out.printf("Nhà xuất bản: %s\n", this.publisher);
        System.out.printf("Giá: %.2f\n", this.price);
        System.out.printf("Mã loại sách: %d\n", this.typeId);
    }
}
